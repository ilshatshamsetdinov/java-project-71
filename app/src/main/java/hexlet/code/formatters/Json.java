package hexlet.code.formatters;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Objects;
import java.util.LinkedHashMap;
public class Json {
    public static String formatJson(Map<String, Object> map1, Map<String, Object> map2) throws JsonProcessingException {
        Map<String, Object> map = new LinkedHashMap<>();
        Set<String> keySet = new TreeSet<>();
        keySet.addAll(map1.keySet());
        keySet.addAll(map2.keySet());
        ObjectMapper mapper = new ObjectMapper();
        for (String key: keySet) {
            if (map1.containsKey(key) && !map2.containsKey(key)) {
                map.put("- " + key, map1.get(key));
            } else if (!map1.containsKey(key) && map2.containsKey(key)) {
                map.put("+ " + key, map2.get(key));
            } else if (map1.containsKey(key) && map2.containsKey(key)
                    && !Objects.equals(map1.get(key), map2.get(key))) {
                map.put("- " + key, map1.get(key));
                map.put("+ " + key, map2.get(key));
            } else {
                map.put("  " + key, map1.get(key));
            }
        }
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
    }
}
