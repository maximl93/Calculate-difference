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
                    result.append("Property '")
                            .append(diff.get("key"))
                            .append("' was removed\r\n");
                    break;
                case "added":
                    result.append("Property '")
                            .append(diff.get("key"))
                            .append("' was added with value: ")
                            .append(defineValueType(diff.get("value")))
                            .append("\r\n");
                    break;
                case "updated":
                    result.append("Property '")
                            .append(diff.get("key"))
                            .append("' was updated. From ")
                            .append(defineValueType(diff.get("value1")))
                            .append(" to ")
                            .append(defineValueType(diff.get("value2")))
                            .append("\r\n");
                    break;
                default:
                    break;
            }
        }

        return result.toString().trim();
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
