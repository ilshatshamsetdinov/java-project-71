package hexlet.code.formatters;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Objects;

public class Stylish {
    public static String formatStylish(Map<String, Object> map1, Map<String, Object> map2) {
        Set<String> keySet = new TreeSet<>();
        keySet.addAll(map1.keySet());
        keySet.addAll(map2.keySet());
        StringBuilder result = new StringBuilder("{\n");
        for (String key : keySet) {
            if (map1.containsKey(key) && !map2.containsKey(key)) {
                result.append("- ").append(key).append(": ").append(map1.get(key)).append("\n");
            } else if (!map1.containsKey(key) && map2.containsKey(key)) {
                result.append("+ ").append(key).append(": ").append(map2.get(key)).append("\n");
            } else if (map1.containsKey(key) && map2.containsKey(key)
                    && !Objects.equals(map1.get(key), map2.get(key))) {
                result.append("- ").append(key).append(": ").append(map1.get(key)).append("\n");
                result.append("+ ").append(key).append(": ").append(map2.get(key)).append("\n");
            } else if (map1.containsKey(key) && map2.containsKey(key)
                    && Objects.equals(map1.get(key), map2.get(key))) {
                result.append("  ").append(key).append(": ").append(map1.get(key)).append("\n");
            }
        }
        result.append("}");
        return result.toString();
    }
}
