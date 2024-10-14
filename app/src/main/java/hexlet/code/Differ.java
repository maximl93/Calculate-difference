package hexlet.code;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static hexlet.code.Format.stylish;
import static hexlet.code.Parser.getFileParser;

public class Differ {

    public static Map<String, Object> mapOfDiff(String filePath1, String filePath2) throws IOException {
        var result = new LinkedHashMap<String, Object>();

        Map<String, Object> file1 = getFileParser(filePath1);
        Map<String, Object> file2 = getFileParser(filePath2);

        List<String> listOfKeys = new ArrayList<>(file1.keySet());
        listOfKeys.addAll(file2.keySet());

        listOfKeys.stream()
                .distinct()
                .sorted()
                .forEach(key -> {
                    if (file1.containsKey(key) && !file2.containsKey(key)) {
                        result.put("- " + key, file1.get(key));
                    } else if (file2.containsKey(key) && !file1.containsKey(key)) {
                        result.put("+ " + key, file2.get(key));
                    } else if (file1.containsKey(key) && file2.containsKey(key) &&
                            !Optional.ofNullable(file1.get(key)).equals(Optional.ofNullable(file2.get(key)))) {
                        result.put("- " + key, file1.get(key));
                        result.put("+ " + key, file2.get(key));
                    } else {
                        result.put("  " + key, file1.get(key));
                    }
                });

        return result;
    }

    public static String generate(String format , String filePath1, String filePath2) throws IOException {
        switch (format) {
            case "stylish":
                return stylish(mapOfDiff(filePath1, filePath2));
            default:
                return "";
        }
    }
}
