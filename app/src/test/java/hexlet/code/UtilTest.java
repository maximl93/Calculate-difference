package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.IOException;

import static hexlet.code.Util.readFile;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilTest {

    private static String expectedJSON;
    private static String expectedYAML;

    @BeforeAll
    public static void expected() {
        expectedJSON = "{\n"
                + "  \"host\": \"hexlet.io\",\n"
                + "  \"timeout\": 50,\n"
                + "  \"proxy\": \"123.234.53.22\",\n"
                + "  \"follow\": false\n"
                + "}";

        expectedYAML = "timeout: 20\nverbose: true\nhost: hexlet.io";
    }

    @Test
    public void readFileJsonTest() throws IOException {
        String filePath = "src/test/resources/fixtures/file1.json";

        String actualJSON = readFile(filePath);

        assertEquals(expectedJSON, actualJSON);

    }

    @Test
    public void readFileYamlTest() throws IOException {
        String filePath = "src/test/resources/fixtures/file2.yaml";

        String actualYAML = readFile(filePath);

        assertEquals(expectedYAML, actualYAML);

    }
}
