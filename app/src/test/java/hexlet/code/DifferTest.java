package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static hexlet.code.Differ.generate;
import static hexlet.code.Util.readFile;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {


    @Test
    public void generateStylishTest() throws IOException {
        var expected = readFile("src/test/resources/fixtures/nestedExpectedStylish.txt");
        var actual1 = generate("stylish",
                "src/test/resources/fixtures/nestedFile1.json",
                "src/test/resources/fixtures/nestedFile2.json");
        var actual2 = generate("stylish",
                "src/test/resources/fixtures/nestedFile1.yaml",
                "src/test/resources/fixtures/nestedFile2.yaml");

        assertEquals(expected, actual1);
        assertEquals(expected, actual2);
    }

    @Test
    public void generatePlainTest() throws IOException {
        var expected = readFile("src/test/resources/fixtures/nestedExpectedPlain.txt");
        var actual1 = generate("plain",
                "src/test/resources/fixtures/nestedFile1.json",
                "src/test/resources/fixtures/nestedFile2.json");
        var actual2 = generate("plain",
                "src/test/resources/fixtures/nestedFile1.yaml",
                "src/test/resources/fixtures/nestedFile2.yaml");

        assertEquals(expected, actual1);
        assertEquals(expected, actual2);
    }
}
