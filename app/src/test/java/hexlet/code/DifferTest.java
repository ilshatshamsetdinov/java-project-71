package hexlet.code;

import static hexlet.code.Differ.generate;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DifferTest {

    String readExpectedFilePath1 = "src/test/resources/ExpectedForPlain";
    Path path1 = Paths.get(readExpectedFilePath1).toAbsolutePath().normalize();
    String readExpectedFilePath2 = "src/test/resources/ExpectedForStylish";
    Path path2 = Paths.get(readExpectedFilePath2).toAbsolutePath().normalize();
    String readExpectedFilePath3 = "src/test/resources/ExpectedForJson";
    Path path3 = Paths.get(readExpectedFilePath3).toAbsolutePath().normalize();



    @Test
    public void testPlainJson() throws Exception {
        String format = "plain";
        String content1 = Files.readString(path1);
        String readFilePath1 = "src/test/resources/testFile3.json";
        String readFilePath2 = "src/test/resources/testFile4.json";
        assertEquals(content1, generate(readFilePath1, readFilePath2, format));
    }

    @Test
    public void testPlainYML() throws Exception {
        String format = "plain";
        String content1 = Files.readString(path1);
        String readFilePath1 = "src/test/resources/testYML3.yml";
        String readFilePath2 = "src/test/resources/testYML4.yml";
        assertEquals(content1, generate(readFilePath1, readFilePath2, format));
    }

    @Test
    public void testStylishJson() throws Exception {
        String format = "stylish";
        String content2 = Files.readString(path2);
        String readFilePath1 = "src/test/resources/testFile3.json";
        String readFilePath2 = "src/test/resources/testFile4.json";
        assertEquals(content2, generate(readFilePath1, readFilePath2, format));
    }
    @Test
    public void testStylishYML() throws Exception {
        String format = "stylish";
        String content2 = Files.readString(path2);
        String readFilePath1 = "src/test/resources/testYML3.yml";
        String readFilePath2 = "src/test/resources/testYML4.yml";
        assertEquals(content2, generate(readFilePath1, readFilePath2, format));
    }
    @Test
    public void testJsonJson() throws Exception {
        String format = "json";
        String content3 = Files.readString(path3);
        String readFilePath1 = "src/test/resources/testFile3.json";
        String readFilePath2 = "src/test/resources/testFile4.json";
        assertEquals(content3, generate(readFilePath1, readFilePath2, format));
    }
    @Test
    public void testJsonYML() throws Exception {
        String format = "json";
        String content3 = Files.readString(path3);
        String readFilePath1 = "src/test/resources/testYML3.yml";
        String readFilePath2 = "src/test/resources/testYML4.yml";
        assertEquals(content3, generate(readFilePath1, readFilePath2, format));
    }

}

