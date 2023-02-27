package hexlet.code;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        Path path1 = Paths.get(filePath1).toAbsolutePath().normalize();
        Path path2 = Paths.get(filePath2).toAbsolutePath().normalize();
        String content1 = Files.readString(path1);
        String content2 = Files.readString(path2);
        if (!Files.exists(path1) && !Files.exists(path2)) {
            throw new Exception("File '" + path1 + path2 + "' does not exist");
        }
        Map<String, Object> map1 = Parser.parser(content1, filePath1);
        Map<String, Object> map2 = Parser.parser(content2, filePath2);
        return Formatter.formatStyle(format, map1, map2);
    }
    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }
}
















































