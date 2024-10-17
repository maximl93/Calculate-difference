package hexlet.code;

import org.junit.jupiter.api.Test;


import java.io.IOException;

import static hexlet.code.Util.readFile;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilTest {

    @Test
    public void readFileTest() throws IOException {
        var filePath1 = "src/test/resources/fixtures/file1.json";
        var filePath2 = "src/test/resources/fixtures/file2.yaml";

        var expected1 = "{\r\n  \"host\": \"hexlet.io\",\r\n  \"timeout\": 50,\r\n  \"proxy\": \"123.234.53.22\",\r\n  \"follow\": false\r\n}";
        var actual1 = readFile(filePath1);
        var expected2 = "timeout: 20\r\nverbose: true\r\nhost: hexlet.io";
        var actual2 = readFile(filePath2);

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }
}
