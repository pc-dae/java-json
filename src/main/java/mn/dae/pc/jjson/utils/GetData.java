package mn.dae.pc.jjson.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class GetData {

    private ObjectMapper objectMapper = new ObjectMapper();

    public Map<String, String> getDataFromFile(String dataFile) throws Exception {
        try {
            return this.objectMapper.readValue(new File(dataFile), Map.class);
        } catch (Exception e) {
            throw e;
        }
    }
}