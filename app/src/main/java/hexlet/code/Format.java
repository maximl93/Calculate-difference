package hexlet.code;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

import static hexlet.code.Differ.mapOfDiff;

public class Format {


    public static String stylish(Map<String, Object> difference) throws IOException {
        return difference.keySet().stream()
                .map(key -> "  " + key + ": " + difference.get(key))
                .collect(Collectors.joining("\n", "{\n", "\n}"));
    }
}
