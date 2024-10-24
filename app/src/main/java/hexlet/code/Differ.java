package hexlet.code;

import java.io.IOException;
import java.util.*;


import static hexlet.code.Parser.getFileParser;
import static hexlet.code.formatters.Formatter.chooseFormatter;

public class Differ {

    public static String generate(String filePath1,
                                  String filePath2,
                                  String formatName) throws IOException, FormatError {
        List<Map<String, Object>> twoFileDifference = new ArrayList<>();

        Map<String, Object> file1 = getFileParser(filePath1);
        Map<String, Object> file2 = getFileParser(filePath2);

        SortedSet<String> setOfProperties = new TreeSet<>(file1.keySet());
        setOfProperties.addAll(file2.keySet());

        setOfProperties.forEach(key -> twoFileDifference.add(findDiff(key, file1, file2)));

        return chooseFormatter(formatName, twoFileDifference);
    }

    public static String generate(String filePath1, String filePath2) throws IOException, FormatError {
        return generate(filePath1, filePath2, "stylish");
    }


    public static Map<String, Object> findDiff(String key, Map<String, Object> file1, Map<String, Object> file2) {
        Map<String, Object> difference = new LinkedHashMap<>();
        difference.put("property", key);

        if (file1.containsKey(key) && !file2.containsKey(key)) {
            difference.put("value", file1.get(key));
            difference.put("status", "removed");
        } else if (file2.containsKey(key) && !file1.containsKey(key)) {
            difference.put("value", file2.get(key));
            difference.put("status", "added");
        } else if (isPropertyUpdated(key, file1, file2)) {
            difference.put("value1", file1.get(key));
            difference.put("value2", file2.get(key));
            difference.put("status", "updated");
        } else {
            difference.put("value", file1.get(key));
            difference.put("status", "unchanged");
        }

        return difference;
    }

    private static boolean isPropertyUpdated(String key, Map<String, Object> file1, Map<String, Object> file2) {
        return file1.containsKey(key)
                && file2.containsKey(key)
                && !Optional.ofNullable(file1.get(key)).equals(Optional.ofNullable(file2.get(key)));
    }
}
