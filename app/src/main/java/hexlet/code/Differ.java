package hexlet.code;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static hexlet.code.Util.jsonToMap;


public class Differ {

    public static Map<String, Object> mapOfDiff(Map<String, Object> file1, Map<String, Object> file2) {
        var result = new LinkedHashMap<String, Object>();

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
                    } else if (file1.containsKey(key) && file2.containsKey(key)
                                && !file1.get(key).equals(file2.get(key))) {
                        result.put("- " + key, file1.get(key));
                        result.put("+ " + key, file2.get(key));
                    } else {
                        result.put(key, file1.get(key));
                    }
                });

        return result;
    }

    public static String generate(String filePath1, String filePath2) throws IOException {
        var difference = mapOfDiff(jsonToMap(filePath1), jsonToMap(filePath2));
        return difference.keySet().stream()
                .map(key -> "  " + key + ": " + difference.get(key))
                .collect(Collectors.joining("\n", "{\n", "\n}"));
    }
}
