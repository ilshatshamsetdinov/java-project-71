package hexlet.code;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;
import java.util.Map;

public class Formatter {
    public static String formatStyle(String format, Map<String, Object> map1,
                                     Map<String, Object> map2) throws Exception {
        switch (format) {
            case "stylish":
                return Stylish.formatStylish(map1, map2);
            case "plain":
                return Plain.formatPlain(map1, map2);
            case "json":
                return Json.formatJson(map1, map2);
            default:
                throw new Exception("Formatting error");
        }
    }
}
