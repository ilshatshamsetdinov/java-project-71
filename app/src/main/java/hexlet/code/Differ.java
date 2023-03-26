package hexlet.code;
import hexlet.code.formatters.Formatter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        Map<String, Object> data1 = Parser.parse(retriveContent(filePath1), filePath1);
        Map<String, Object> data2 = Parser.parse(retriveContent(filePath2), filePath2);
        List<Map<String, Object>> result = DiffBuilder.differ(data1, data2);
        return Formatter.formatStyle(format, result);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }

    public static String retriveContent(String filePath) throws Exception {
        Path path = Paths.get(filePath).toAbsolutePath().normalize();
        String content = Files.readString(path);
        if (!Files.exists(path)) {
            throw new Exception("File '" + path + "' does not exist");
        }
        return content;
    }
}

















































