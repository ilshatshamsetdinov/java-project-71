package hexlet.code.formatters;
import java.util.List;
import java.util.Map;

public class Formatter {
    public static String formatStyle(String format, List<Map<String, Object>> differences) throws Exception {
        switch (format) {
            case "stylish":
                return Stylish.format(differences);
            case "plain":
                return Plain.format(differences);
            case "json":
                return Json.format(differences);
            default:
                throw new Exception("Formatting error");
        }
    }
}
