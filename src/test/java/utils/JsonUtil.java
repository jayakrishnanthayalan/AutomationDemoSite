package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class JsonUtil {
    private static final ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    private static final String FILE_PATH = "target/runtime-data/testData.json";

    public static void writeValue(String key, String value) {
        try {
            File file = new File(FILE_PATH);
            file.getParentFile().mkdirs();

            Map<String, String> data = file.exists() ? mapper.readValue(file, HashMap.class) : new HashMap<>();
            data.put(key, value);
            mapper.writeValue(file, data);

        } catch (Exception e) {
            throw new RuntimeException("Failed to write JSON", e);
        }
    }

    // Read values
    public static String readValue(String key) {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) return null;

            Map<String, String> data = mapper.readValue(file, HashMap.class);
            return data.get(key);

        } catch (Exception e) {
            throw new RuntimeException("Failed to read JSON", e);
        }
    }
}
