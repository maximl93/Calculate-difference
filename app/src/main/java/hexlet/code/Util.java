package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;


public class Util {

    public static Path getFilePath(String filePath) {
        return Paths.get(filePath).toAbsolutePath().normalize();
    }

    public static String readFile(String filePath) throws IOException {
        var path = getFilePath(filePath);
        return Files.readString(path).trim();
    }

    public static Map<String, Object> jsonToMap(String filePath) throws IOException {
        var json = readFile(filePath);
        return new ObjectMapper().readValue(json, new TypeReference<>() { });
    }
}
