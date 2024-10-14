package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Util {

    public static Path getFilePath(String filePath) {
        return Paths.get(filePath).toAbsolutePath().normalize();
    }

    public static String readFile(String filePath) throws IOException {
        var path = getFilePath(filePath);
        return Files.readString(path);
    }



}
