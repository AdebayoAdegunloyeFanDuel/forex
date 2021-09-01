package object_mapping_forex;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ForexRatesDeserialiser {
    private ObjectMapper objectMapper = new ObjectMapper();

    public ForexJsonDTO fixerLatestRatesData(File json_file_location) {
        try {
            return objectMapper.readValue(json_file_location, ForexJsonDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ForexJsonDTO fixerLatestRatesData(String json_string) {
        try {
            return objectMapper.readValue(json_string, ForexJsonDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
