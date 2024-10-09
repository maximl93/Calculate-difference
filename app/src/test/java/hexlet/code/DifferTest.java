package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static hexlet.code.Differ.mapOfDiff;
import static hexlet.code.Util.jsonToMap;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    @Test
    public void getDiffTest() throws IOException {
        var expected = jsonToMap("expected.json");
        var actual = mapOfDiff(jsonToMap("file1.json"), jsonToMap("file2.json"));
        assertEquals(expected, actual);
    }
}
