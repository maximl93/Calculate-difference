package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static hexlet.code.Differ.mapOfDiff;
import static hexlet.code.Util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilTest {

    @Test
    public void getPathTest() {
        var actual1 = getFilePath("file1.json");
        assertEquals("/", actual1);
    }


    @Test
    public void jsonToMapTest() throws IOException {
        var expectedFile1 = jsonToMap("file1.json");
        var expectedFile2 = jsonToMap("file2.json");
        assertEquals(expectedFile1, Map.of("host", "hexlet.io",
                                            "timeout", 50,
                                            "proxy", "123.234.53.22",
                                            "follow", false));
        assertEquals(expectedFile2, Map.of("timeout", 20,
                                            "verbose", true,
                                            "host", "hexlet.io"));
    }


}
