package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static hexlet.code.Differ.generate;
import static hexlet.code.Util.readFile;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    private static String expectedStylish;
    private static String expectedPlain;
    private static String expectedJSON;

    @BeforeAll
    public static void expectingOutcome() throws IOException {
        expectedStylish = readFile("src/test/resources/fixtures/nestedExpectedStylish.txt");
        expectedPlain = readFile("src/test/resources/fixtures/nestedExpectedPlain.txt");
        expectedJSON = readFile("src/test/resources/fixtures/nestedExpectedJson.txt");
    }


    @Test
    public void generateStylishTestJson() throws IOException {
        String actual = generate("src/test/resources/fixtures/nestedFile1.json",
                "src/test/resources/fixtures/nestedFile2.json",
                "stylish");

        assertEquals(expectedStylish, actual);
    }

    @Test
    public void generateStylishTestYaml() throws IOException {
        String actual = generate("src/test/resources/fixtures/nestedFile1.yaml",
                "src/test/resources/fixtures/nestedFile2.yaml",
                "stylish");

        assertEquals(expectedStylish, actual);
    }

    @Test
    public void generatePlainTestJson() throws IOException {
        String actual = generate("src/test/resources/fixtures/nestedFile1.json",
                "src/test/resources/fixtures/nestedFile2.json",
                "plain");

        assertEquals(expectedPlain, actual);
    }

    @Test
    public void generatePlainTestYaml() throws IOException {
        String actual = generate("src/test/resources/fixtures/nestedFile1.yaml",
                "src/test/resources/fixtures/nestedFile2.yaml",
                "plain");

        assertEquals(expectedPlain, actual);
    }

    @Test
    public void generateJsonTestJson() throws IOException {
        String actual = generate("src/test/resources/fixtures/nestedFile1.json",
                "src/test/resources/fixtures/nestedFile2.json",
                "json");

        assertEquals(expectedJSON, actual);
    }


}
