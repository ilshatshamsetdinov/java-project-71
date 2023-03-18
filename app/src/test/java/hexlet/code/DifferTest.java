package hexlet.code;

import static hexlet.code.Differ.generate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class DifferTest {
    private static String expected = """
            Property 'chars2' was updated. From [complex value] to false
            Property 'checked' was updated. From false to true
            Property 'default' was updated. From null to [complex value]
            Property 'id' was updated. From 45 to null
            Property 'key1' was removed
            Property 'key2' was added with value: 'value2'
            Property 'numbers2' was updated. From [complex value] to [complex value]
            Property 'numbers3' was removed
            Property 'numbers4' was added with value: [complex value]
            Property 'obj1' was added with value: [complex value]
            Property 'setting1' was updated. From 'Some value' to 'Another value'
            Property 'setting2' was updated. From 200 to 300
            Property 'setting3' was updated. From true to 'none'""";

    private static String expected2 = """
              {
                  chars1: [a, b, c]
                - chars2: [d, e, f]
                + chars2: false
                - checked: false
                + checked: true
                - default: null
                + default: [value1, value2]
                - id: 45
                + id: null
                - key1: value1
                + key2: value2
                  numbers1: [1, 2, 3, 4]
                - numbers2: [2, 3, 4, 5]
                + numbers2: [22, 33, 44, 55]
                - numbers3: [3, 4, 5]
                + numbers4: [4, 5, 6]
                + obj1: {nestedKey=value, isNested=true}
                - setting1: Some value
                + setting1: Another value
                - setting2: 200
                + setting2: 300
                - setting3: true
                + setting3: none
              }""";
    private static String expected3 = """
            [ {
              "key" : "chars1",
              "oldValue" : [ "a", "b", "c" ],
              "status" : "unchanged"
            }, {
              "key" : "chars2",
              "oldValue" : [ "d", "e", "f" ],
              "newValue" : false,
              "status" : "updated"
            }, {
              "key" : "checked",
              "oldValue" : false,
              "newValue" : true,
              "status" : "updated"
            }, {
              "key" : "default",
              "oldValue" : null,
              "newValue" : [ "value1", "value2" ],
              "status" : "updated"
            }, {
              "key" : "id",
              "oldValue" : 45,
              "newValue" : null,
              "status" : "updated"
            }, {
              "key" : "key1",
              "oldValue" : "value1",
              "status" : "removed"
            }, {
              "key" : "key2",
              "newValue" : "value2",
              "status" : "added"
            }, {
              "key" : "numbers1",
              "oldValue" : [ 1, 2, 3, 4 ],
              "status" : "unchanged"
            }, {
              "key" : "numbers2",
              "oldValue" : [ 2, 3, 4, 5 ],
              "newValue" : [ 22, 33, 44, 55 ],
              "status" : "updated"
            }, {
              "key" : "numbers3",
              "oldValue" : [ 3, 4, 5 ],
              "status" : "removed"
            }, {
              "key" : "numbers4",
              "newValue" : [ 4, 5, 6 ],
              "status" : "added"
            }, {
              "key" : "obj1",
              "newValue" : {
                "nestedKey" : "value",
                "isNested" : true
              },
              "status" : "added"
            }, {
              "key" : "setting1",
              "oldValue" : "Some value",
              "newValue" : "Another value",
              "status" : "updated"
            }, {
              "key" : "setting2",
              "oldValue" : 200,
              "newValue" : 300,
              "status" : "updated"
            }, {
              "key" : "setting3",
              "oldValue" : true,
              "newValue" : "none",
              "status" : "updated"
            } ]""";

    @Test
    public void testPlainJson() throws Exception {
        String format = "plain";
        String readFilePath1 = "src/test/resources/testFile3.json";
        String readFilePath2 = "src/test/resources/testFile4.json";
        assertEquals(expected, generate(readFilePath1, readFilePath2, format));
    }

    @Test
    public void testPlainYML() throws Exception {
        String format = "plain";
        String readFilePath1 = "src/test/resources/testYML3.yml";
        String readFilePath2 = "src/test/resources/testYML4.yml";
        assertEquals(expected, generate(readFilePath1, readFilePath2, format));
    }

    @Test
    public void testStylishJson() throws Exception {
        String format = "stylish";
        String readFilePath1 = "src/test/resources/testFile3.json";
        String readFilePath2 = "src/test/resources/testFile4.json";
        assertEquals(expected2, generate(readFilePath1, readFilePath2, format));
    }
    @Test
    public void testStylishYML() throws Exception {
        String format = "stylish";
        String readFilePath1 = "src/test/resources/testYML3.yml";
        String readFilePath2 = "src/test/resources/testYML4.yml";
        assertEquals(expected2, generate(readFilePath1, readFilePath2, format));
    }
    @Test
    public void testJsonJson() throws Exception {
        String format = "json";
        String readFilePath1 = "src/test/resources/testFile3.json";
        String readFilePath2 = "src/test/resources/testFile4.json";
        assertEquals(expected3, generate(readFilePath1, readFilePath2, format));
    }
    @Test
    public void testJsonYML() throws Exception {
        String format = "json";
        String readFilePath1 = "src/test/resources/testYML3.yml";
        String readFilePath2 = "src/test/resources/testYML4.yml";
        assertEquals(expected3, generate(readFilePath1, readFilePath2, format));
    }

}
