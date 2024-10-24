package hexlet.code.formatters;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static hexlet.code.formatters.Json.json;
import static hexlet.code.formatters.Stylish.stylish;
import static hexlet.code.formatters.Plain.plain;

public class Formatter {
    public static String chooseFormatter(String format, List<Map<String, Object>> difference) throws IOException {
        return switch (format) {
            case "stylish" -> stylish(difference);
            case "plain" -> plain(difference);
            case "json" -> json(difference);
            default -> "No such formatter exist";
        };
    }
}
