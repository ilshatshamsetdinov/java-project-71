package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Differ {
    public static String generate(String filePath1, String filePath2) throws Exception {
        Path path1 = Paths.get(filePath1).toAbsolutePath().normalize();
        Path path2 = Paths.get(filePath2).toAbsolutePath().normalize();
        String content1 = Files.readString(path1);
        String content2 = Files.readString(path2);
        if (!Files.exists(path1) && !Files.exists(path2)) {
            throw new Exception("File '" + path1 + path2 + "' does not exist");
        }
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map1
                = objectMapper.readValue(content1, new TypeReference<Map<String, Object>>() { });
        Map<String, Object> map2
                = objectMapper.readValue(content2, new TypeReference<Map<String, Object>>() { });
        Map<String, Object> linkedHashMap = new LinkedHashMap<>();
        Set<String> keySet = new TreeSet<>();
        keySet.addAll(map1.keySet());
        keySet.addAll(map2.keySet());
        var result = new StringBuilder("{\n");
        for (String k: keySet) {
            if (!map1.containsKey(k) && map2.containsKey(k)) {
                //linkedHashMap.put(k, map2.get(k));
                result.append("+ ").append(k).append(": ").append(map2.get(k)).append("\n");
            } else if (map1.containsKey(k) && !map2.containsKey(k)) {
                //linkedHashMap.put(k, map1.get(k));
                result.append("- ").append(k).append(": ").append(map1.get(k)).append("\n");
            } else if (map1.containsKey(k) && map2.containsKey(k) && !map1.get(k).equals(map2.get(k))) {
               // linkedHashMap.put(k, map1.get(k));
                result.append("- ").append(k).append(": ").append(map1.get(k)).append("\n");
                //linkedHashMap.put(k, map2.get(k));
                result.append("+ ").append(k).append(": ").append(map2.get(k)).append("\n");
            } else if (map1.containsKey(k) && map2.containsKey(k) && map1.get(k).equals(map2.get(k))) {
                //linkedHashMap.put(k, map1.get(k));
                result.append("  ").append(k).append(": ").append(map1.get(k)).append("\n");
            }
        }
        result.append("}");
        return result.toString();
    }
}




