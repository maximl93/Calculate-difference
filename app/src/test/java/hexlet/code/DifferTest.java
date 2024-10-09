package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static hexlet.code.Differ.generate;
import static hexlet.code.Differ.mapOfDiff;
import static hexlet.code.Util.jsonToMap;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    @Test
    public void getDiffTest() throws IOException {
        var expected = jsonToMap("src/test/resources/fixtures/expected.json");
        var actual = mapOfDiff(jsonToMap("src/test/resources/fixtures/file1.json"),
                                jsonToMap("src/test/resources/fixtures/file2.json"));
        assertEquals(expected, actual);
    }

    @Test
    public void generateTest() throws IOException {
        var expected = "{\n"
                + "  - follow: false\n"
                + "  host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";
        var actual = generate("src/test/resources/fixtures/file1.json", "src/test/resources/fixtures/file2.json");
        assertEquals(expected, actual);
    }
}
