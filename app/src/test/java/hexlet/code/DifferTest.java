package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static hexlet.code.Differ.generate;
import static hexlet.code.Util.readFile;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {


    @Test
    public void generateStylishTest() throws IOException, FormatError {
        var expected = readFile("src/test/resources/fixtures/nestedExpectedStylish.txt");
        var actual1 = generate("src/test/resources/fixtures/nestedFile1.json",
                "src/test/resources/fixtures/nestedFile2.json",
                "stylish");
        var actual2 = generate("src/test/resources/fixtures/nestedFile1.yaml",
                "src/test/resources/fixtures/nestedFile2.yaml",
                "stylish");

        assertEquals(expected, actual1);
        assertEquals(expected, actual2);
    }

    @Test
    public void generatePlainTest() throws IOException, FormatError {
        var expected = readFile("src/test/resources/fixtures/nestedExpectedPlain.txt");
        var actual1 = generate("src/test/resources/fixtures/nestedFile1.json",
                "src/test/resources/fixtures/nestedFile2.json",
                "plain");
        var actual2 = generate("src/test/resources/fixtures/nestedFile1.yaml",
                "src/test/resources/fixtures/nestedFile2.yaml",
                "plain");

        assertEquals(expected, actual1);
        assertEquals(expected, actual2);
    }

    @Test
    public void generateJsonTest() throws IOException, FormatError {
        var expected = readFile("src/test/resources/fixtures/nestedExpectedJson.txt");
        var actual1 = generate("src/test/resources/fixtures/nestedFile1.json",
                "src/test/resources/fixtures/nestedFile2.json",
                "json");

        assertEquals(expected, actual1);
    }
}
