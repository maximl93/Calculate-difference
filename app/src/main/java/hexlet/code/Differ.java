package hexlet.code;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.LinkedHashMap;
import java.util.Optional;


import static hexlet.code.Parser.getFileParser;
import static hexlet.code.formatters.Formatter.chooseFormatter;

public class Differ {

    public static String generate(String filePath1,
                                  String filePath2,
                                  String formatName) throws IOException {
        List<Map<String, Object>> twoFileDifference = new ArrayList<>();

        Map<String, Object> file1 = getFileParser(filePath1);
        Map<String, Object> file2 = getFileParser(filePath2);

        SortedSet<String> setOfProperties = new TreeSet<>(file1.keySet());
        setOfProperties.addAll(file2.keySet());

        setOfProperties.forEach(key -> twoFileDifference.add(findDiff(key, file1, file2)));

        return chooseFormatter(formatName, twoFileDifference);
    }

    public static String generate(String filePath1, String filePath2) throws IOException {
        return generate(filePath1, filePath2, "stylish");
    }


    public static Map<String, Object> findDiff(String key, Map<String, Object> file1, Map<String, Object> file2) {
        Map<String, Object> difference = new LinkedHashMap<>();

        if (file1.containsKey(key) && !file2.containsKey(key)) {
            propertyRemoved(difference, file1, key);
        } else if (file2.containsKey(key) && !file1.containsKey(key)) {
            propertyAdded(difference, file2, key);
        } else if (isPropertyUpdated(key, file1, file2)) {
            propertyUpdated(difference, file1, file2, key);
        } else {
            propertyUnchanged(difference, file1, key);
        }

        return difference;
    }

    private static boolean isPropertyUpdated(String key, Map<String, Object> file1, Map<String, Object> file2) {
        return file1.containsKey(key)
                && file2.containsKey(key)
                && !Optional.ofNullable(file1.get(key)).equals(Optional.ofNullable(file2.get(key)));
    }

    public static void propertyRemoved(Map<String, Object> difference, Map<String, Object> file1, String key) {
        difference.put("property", key);
        difference.put("value", file1.get(key));
        difference.put("status", "removed");
    }

    public static void propertyAdded(Map<String, Object> difference, Map<String, Object> file2, String key) {
        difference.put("property", key);
        difference.put("value", file2.get(key));
        difference.put("status", "added");
    }

    public static void propertyUpdated(Map<String, Object> difference, Map<String, Object> file1,
                                       Map<String, Object> file2, String key) {
        difference.put("property", key);
        difference.put("value1", file1.get(key));
        difference.put("value2", file2.get(key));
        difference.put("status", "updated");
    }

    public static void propertyUnchanged(Map<String, Object> difference, Map<String, Object> file1, String key) {
        difference.put("property", key);
        difference.put("value", file1.get(key));
        difference.put("status", "unchanged");
    }
}
