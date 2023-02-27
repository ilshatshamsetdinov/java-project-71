package hexlet.code.formatters;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Objects;
import java.util.Collections;
import java.util.ArrayList;
public class Plain {
    public static String formatPlain(Map<String, Object> map1, Map<String, Object> map2) {
        Set<String> keySet = new TreeSet<>();
        keySet.addAll(map1.keySet());
        keySet.addAll(map2.keySet());
        StringBuilder result = new StringBuilder();
        for (String key : keySet) {
            if (map1.containsKey(key) && !map2.containsKey(key)) {
                result.append("Property ").append("'").append(key).append("'")
                        .append(" was removed").append("\n");
            } else if (!map1.containsKey(key) && map2.containsKey(key)) {
                result.append("Property ").append(complexValue(key))
                        .append(" was added with value: ")
                        .append(complexValue(map2.get(key)))
                        .append("\n");
            } else if (map1.containsKey(key) && map2.containsKey(key)
                    && !Objects.equals(map1.get(key), map2.get(key))) {
                result.append("Property ").append(complexValue(key))
                        .append(" was updated. From ")
                        .append(complexValue(map1.get(key))).append(" to ")
                        .append(complexValue(map2.get(key)))
                        .append("\n");
            } else {
                result.append("");
            }
        }
        return result.toString().trim();

    }
    public static String complexValue(Object data) {
        if (data instanceof Object[] || data instanceof Collections || data instanceof Map
                || data instanceof ArrayList<?>) {
            return "[complex value]";
        } else if (data instanceof String) {
            return "'" + data + "'";
        } else if (data == null) {
            return null;
        }
        return data.toString();
    }
}
