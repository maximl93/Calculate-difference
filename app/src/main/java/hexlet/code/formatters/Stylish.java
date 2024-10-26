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
                    propertyRemoved(result, diff);
                    break;
                case "added":
                    propertyAdded(result, diff);
                    break;
                case "updated":
                    propertyUpdated(result, diff);
                    break;
                case "unchanged":
                    propertyUnchanged(result, diff);
                default:
                    break;
            }
        }

        return result.append("}").toString().trim();
    }

    public static void propertyRemoved(StringBuilder result, Map<String, Object> diff) {
        result.append("  - ");
        addToResult(result, diff.get("property"), diff.get("value"));
    }

    public static void propertyAdded(StringBuilder result, Map<String, Object> diff) {
        result.append("  + ");
        addToResult(result, diff.get("property"), diff.get("value"));
    }

    public static void propertyUpdated(StringBuilder result, Map<String, Object> diff) {
        result.append("  - ");
        addToResult(result, diff.get("property"), diff.get("value1"));
        result.append("  + ");
        addToResult(result, diff.get("property"), diff.get("value2"));
    }

    public static void propertyUnchanged(StringBuilder result, Map<String, Object> diff) {
        result.append("    ");
        addToResult(result, diff.get("property"), diff.get("value"));
    }

    private static void addToResult(StringBuilder result, Object property, Object value) {
        result.append(property)
                .append(": ")
                .append(value)
                .append("\n");
    }
}
