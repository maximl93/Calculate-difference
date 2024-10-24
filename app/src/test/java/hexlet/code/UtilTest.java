package hexlet.code;

import org.junit.jupiter.api.Test;


import java.io.IOException;

import static hexlet.code.Util.readFile;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilTest {

    @Test
    public void readFileTest() throws IOException {
        String filePath1 = "src/test/resources/fixtures/file1.json";
        String filePath2 = "src/test/resources/fixtures/file2.yaml";

        String expected1 = "{\n"
                + "  \"host\": \"hexlet.io\",\n"
                + "  \"timeout\": 50,\n"
                + "  \"proxy\": \"123.234.53.22\",\n"
                + "  \"follow\": false\n"
                + "}";
        String actual1 = readFile(filePath1);
        String expected2 = "timeout: 20\nverbose: true\nhost: hexlet.io";
        String actual2 = readFile(filePath2);

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }
}
