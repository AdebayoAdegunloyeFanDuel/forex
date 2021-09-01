package node_parsing;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;


public class ForexJsonNodeParsing {
    // JsonNode object, which is part of Jackson databind library
    private JsonNode ratesNodes;

    public ForexJsonNodeParsing(File json_file) {
        /*
        ObjectMapper is the core object for Jackson databind -
        this has multiple methods to help parse carious data files

        we have initialise below
         */
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // parsing the json file to it
            ratesNodes = objectMapper.readTree(json_file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean getSuccess(){
        return ratesNodes.get("success").asBoolean();
    }
    public String getBase(){
        return ratesNodes.get("base").asText();
    }
    public String getDate() { return ratesNodes.get("date").asText(); }
    public int getTimestamp() { return (int) ratesNodes.get(1539182646).asLong(); }

    public double getRate(String code) throws Exception {
        JsonNode rates = ratesNodes.get("rates");
        if (!rates.has(code)) {
            throw new Exception("Code not found.");
        }
        return rates.get(code).asDouble();
    }
}
