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

        var expected1 = "{\n  \"host\": \"hexlet.io\",\n  \"timeout\": 50,\n  \"proxy\": \"123.234.53.22\",\n  \"follow\": false\n}";
        var expected2 = "timeout: 20\nverbose: true\nhost: hexlet.io";
        assertEquals(expected1, readFile(filePath1));
        assertEquals(expected2, readFile(filePath2));
    }
}
