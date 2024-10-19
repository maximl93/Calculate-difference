package hexlet.code;

import java.io.IOException;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Optional;


import static hexlet.code.Parser.getFileParser;
import static hexlet.code.formatters.Formatter.chooseFormatter;

public class Differ {

    public static String generate(String format, String filePath1, String filePath2) throws IOException, FormatError {
        List<Map<String, Object>> twoFileDifference = new ArrayList<>();

        Map<String, Object> file1 = getFileParser(filePath1);
        Map<String, Object> file2 = getFileParser(filePath2);

        List<String> listOfKeys = new ArrayList<>(file1.keySet());
        listOfKeys.addAll(file2.keySet());

        listOfKeys.stream()
                .distinct()
                .sorted()
                .forEach(key -> {
                    twoFileDifference.add(findDiff(key, file1, file2));
                });

        return chooseFormatter(format, twoFileDifference);
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
        } else if (file1.containsKey(key) && file2.containsKey(key)
                && !Optional.ofNullable(file1.get(key)).equals(Optional.ofNullable(file2.get(key)))) {
            difference.put("value1", file1.get(key));
            difference.put("value2", file2.get(key));
            difference.put("status", "updated");
        } else {
            difference.put("value", file1.get(key));
            difference.put("status", "unchanged");
        }

        return difference;
    }
}
