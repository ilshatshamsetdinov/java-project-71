package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.TreeMap;

public class Parser {
    public static TreeMap<String, Object> parser(String content, String filepath) throws IOException {
        ObjectMapper objectmapper = chooseFormat(filepath);
        return objectmapper.readValue(content, new TypeReference<>() { });
    }
    private static ObjectMapper chooseFormat(String filepath) {
        return filepath.endsWith(".json") ? new ObjectMapper() : new ObjectMapper(new YAMLFactory());
    }
}
