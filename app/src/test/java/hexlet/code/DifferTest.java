package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static hexlet.code.Differ.generate;
import static hexlet.code.Differ.mapOfDiff;
import static hexlet.code.Parser.jsonToMap;
import static hexlet.code.Parser.yamlToMap;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    @Test
    public void getDiffTest() throws IOException {
        var expected1 = jsonToMap("src/test/resources/fixtures/expected.json");
        var actual1 = mapOfDiff("src/test/resources/fixtures/file1.json",
                                "src/test/resources/fixtures/file2.json");
        assertEquals(expected1, actual1);

        var expected2 = yamlToMap("src/test/resources/fixtures/expected.yaml");
        var actual2 = mapOfDiff("src/test/resources/fixtures/file1.yaml",
                                "src/test/resources/fixtures/file2.yaml");
        assertEquals(expected2, actual2);
    }

    @Test
    public void generateTest() throws IOException {
        var expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";
        var actual1 = generate("stylish" ,"src/test/resources/fixtures/file1.json", "src/test/resources/fixtures/file2.json");
        assertEquals(expected, actual1);

        var actual2 = generate("stylish" ,"src/test/resources/fixtures/file1.yaml", "src/test/resources/fixtures/file2.yaml");
        assertEquals(expected, actual2);

        var expected2 = "{\n"
                + "  + host: hexlet.io\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";
        var actual3 = generate("stylish" ,"src/test/resources/fixtures/empty.json", "src/test/resources/fixtures/file2.json");
        var actual4 = generate("stylish" ,"src/test/resources/fixtures/empty.yaml", "src/test/resources/fixtures/file2.yaml");
        assertEquals(expected2, actual3);
        assertEquals(expected2, actual4);
    }
}
