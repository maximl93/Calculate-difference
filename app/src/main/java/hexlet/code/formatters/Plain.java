package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Plain {

    public static String plain(List<Map<String, Object>> difference) {
        StringBuilder result = new StringBuilder();
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
                default:
                    break;
            }
        }

        return result.toString().trim();
    }

    public static void propertyRemoved(StringBuilder result, Map<String, Object> diff) {
        result.append("Property '")
                .append(diff.get("property"))
                .append("' was removed\n");
    }

    public static void propertyAdded(StringBuilder result, Map<String, Object> diff) {
        result.append("Property '")
                .append(diff.get("property"))
                .append("' was added with value: ")
                .append(defineValueType(diff.get("value")))
                .append("\n");
    }

    public static void propertyUpdated(StringBuilder result, Map<String, Object> diff) {
        result.append("Property '")
                .append(diff.get("property"))
                .append("' was updated. From ")
                .append(defineValueType(diff.get("value1")))
                .append(" to ")
                .append(defineValueType(diff.get("value2")))
                .append("\n");
    }

    public static <T> String defineValueType(T value) {
        if (value instanceof String) {
            return "'" + value + "'";
        } else if (value == null) {
            return "null";
        } else if (value instanceof List<?> || value instanceof Map<?, ?>) {
            return "[complex value]";
        } else {
            return value.toString();
        }
    }

}
