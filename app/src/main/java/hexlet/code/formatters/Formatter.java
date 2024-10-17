package hexlet.code.formatters;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static hexlet.code.formatters.Stylish.stylish;
import static hexlet.code.formatters.Plain.plain;

public class Formatter {
    public static String chooseFormatter(String format, List<Map<String, Object>> difference) throws IOException {
        switch (format) {
            case "stylish":
                return stylish(difference);
            case "plain":
                return plain(difference);
            default:
                return "No such formatter exist";
        }
    }
}
