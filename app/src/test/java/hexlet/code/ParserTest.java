//package hexlet.code;
//
//import org.junit.jupiter.api.Test;
//
//import java.io.IOException;
//import java.util.Map;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import static hexlet.code.Parser.jsonToMap;
//import static hexlet.code.Parser.yamlToMap;
//
//public class ParserTest {
//
//    @Test
//    public void jsonToMapTest() throws IOException {
//        var actualFile1 = jsonToMap("src/test/resources/fixtures/file1.json");
//        var actualFile2 = jsonToMap("src/test/resources/fixtures/file2.json");
//        assertEquals(Map.of("host", "hexlet.io",
//                "timeout", 50,
//                "proxy", "123.234.53.22",
//                "follow", false), actualFile1);
//        assertEquals(Map.of("timeout", 20,
//                "verbose", true,
//                "host", "hexlet.io"), actualFile2);
//    }
//
//    @Test
//    public void yamlToMapTest() throws IOException {
//        var actualFile1 = yamlToMap("src/test/resources/fixtures/file1.yaml");
//        var actualFile2 = yamlToMap("src/test/resources/fixtures/file2.yaml");
//        assertEquals(Map.of("host", "hexlet.io",
//                "timeout", 50,
//                "proxy", "123.234.53.22",
//                "follow", false), actualFile1);
//        assertEquals(Map.of("timeout", 20,
//                "verbose", true,
//                "host", "hexlet.io"), actualFile2);
//    }
//
//}
