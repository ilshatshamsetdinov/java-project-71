package hexlet.code;

import static hexlet.code.Differ.generate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class DifferTest {
    private static String expected = """
            {
              - follow: true
                host: hex.io
              - proxy: 1.1.1.1
              - timeout: 60
              + timeout: 40
              + verbose: false
            }""";
    @Test
    public static void testGenerate() throws Exception {
        String readFilePath1 = "/test/resources/testFile2.json";
        String readFilePath2 = "/test/resources/testFile2.json";
        assertEquals(expected, generate(readFilePath1, readFilePath2));
    }
}
