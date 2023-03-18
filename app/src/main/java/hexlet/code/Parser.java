package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;


public class Parser {
    public static Map<String, Object> parser(String content, String filePath) throws Exception {
        String extension = filePath.substring(filePath.indexOf(".") + 1);
        switch (extension) {
            case "json" -> {
                return parseJson(content);
            }
            case "yaml", "yml" -> {
                return parseYml(content);
            }
            default -> throw new Exception("Unavailable  format");
        }
    }

    private static Map<String, Object> parseJson(String content) throws JsonProcessingException {
        ObjectMapper objectmapper = new ObjectMapper();
        return objectmapper.readValue(content, new TypeReference<>() { });
    }
    private static Map<String, Object> parseYml(String content) throws JsonProcessingException {
        ObjectMapper objectmapper = new YAMLMapper();
        return objectmapper.readValue(content, new TypeReference<>() { });
    }

}

