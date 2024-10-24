package hexlet.code.formatters;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Stylish {

    public static String stylish(List<Map<String, Object>> difference) throws IOException {
        StringBuilder result = new StringBuilder("{\n");
        for (Map<String, Object> diff : difference) {
            String status = diff.get("status").toString();
            switch (status) {
                case "removed":
                    result.append("  - ");
                    addToResult(result, diff.get("property"), diff.get("value"));
                    break;
                case "added":
                    result.append("  + ");
                    addToResult(result, diff.get("property"), diff.get("value"));
                    break;
                case "updated":
                    result.append("  - ");
                    addToResult(result, diff.get("property"), diff.get("value1"));
                    result.append("  + ");
                    addToResult(result, diff.get("property"), diff.get("value2"));
                    break;
                case "unchanged":
                    result.append("    ");
                    addToResult(result, diff.get("property"), diff.get("value"));
                default:
                    break;
            }
        }

        return result.append("}").toString().trim();
    }

    private static void addToResult(StringBuilder result, Object property, Object value) {
        result.append(property)
                .append(": ")
                .append(value)
                .append("\n");
    }
}
