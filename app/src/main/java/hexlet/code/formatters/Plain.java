package hexlet.code.formatters;
import java.util.List;
import java.util.Map;

public class Plain {
    public static String format(List<Map<String, Object>> differences) {
        StringBuilder result = new StringBuilder();
        for (Map<String, Object> diffs : differences) {
            switch (diffs.get("status").toString()) {
                case "removed" -> result.append(String.format("Property '%s' was removed\n", diffs.get("key")));
                case "added" -> result.append(String.format("Property %s was added with value: %s\n",
                        complexValue(diffs.get("key")),
                        complexValue(diffs.get("newValue"))));
                case "updated" -> result.append(String.format("Property %s was updated. From %s to %s\n",
                        complexValue(diffs.get("key")), complexValue(diffs.get("oldValue")),
                        complexValue(diffs.get("newValue"))));
                default -> result.append("");
            }
        }
        return result.toString().trim();
    }

    public static String complexValue(Object data) {
        if (data == null) {
            return "null";
        } else if (data instanceof String) {
            return "'" + data + "'";
        } else if (data instanceof Integer || data instanceof Boolean) {
            return String.valueOf(data);
        }
        return "[complex value]";
    }
}
