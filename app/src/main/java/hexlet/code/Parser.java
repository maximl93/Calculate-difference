package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.util.Map;

import static hexlet.code.Util.readFile;

public class Parser {
    public static Map<String, Object> jsonToMap(String filePath) throws IOException {
        var json = readFile(filePath);
        if (json.isEmpty()) {
            return Map.of();
        }
        return new ObjectMapper().readValue(json, new TypeReference<>() { });
    }

    public static Map<String, Object> yamlToMap(String filePath) throws IOException {
        var yaml = readFile(filePath);
        if (yaml.isEmpty()) {
            return Map.of();
        }
        ObjectMapper mapper = YAMLMapper.builder()
                .disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER)
                .build();
        return mapper.readValue(yaml,new TypeReference<>() { });
    }

    public static Map<String, Object> getFileParser(String filePath) throws IOException {
        var fileFormat = filePath.substring(filePath.lastIndexOf(".") + 1);

        if (fileFormat.equals("json")) {
            return jsonToMap(filePath);
        } else {
            return yamlToMap(filePath);
        }
    }
}
