package hexlet.code.formatters;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Stylish {

    public static String stylish(List<Map<String, Object>> difference) throws IOException {
        StringBuilder result = new StringBuilder("{\r\n");
        for (Map<String, Object> diff : difference) {
            String status = diff.get("status").toString();
            switch (status) {
                case "removed":
                    result.append("  - ")
                            .append(diff.get("property"))
                            .append(": ")
                            .append(diff.get("value"))
                            .append("\r\n");
                    break;
                case "added":
                    result.append("  + ")
                            .append(diff.get("property"))
                            .append(": ")
                            .append(diff.get("value"))
                            .append("\r\n");
                    break;
                case "updated":
                    result.append("  - ")
                            .append(diff.get("property"))
                            .append(": ")
                            .append(diff.get("value1"))
                            .append("\r\n");
                    result.append("  + ")
                            .append(diff.get("property"))
                            .append(": ")
                            .append(diff.get("value2"))
                            .append("\r\n");
                    break;
                case "unchanged":
                    result.append("    ")
                            .append(diff.get("property"))
                            .append(": ")
                            .append(diff.get("value"))
                            .append("\r\n");
                default:
                    break;
            }
        }


        return result.append("}").toString().trim();
    }
}
