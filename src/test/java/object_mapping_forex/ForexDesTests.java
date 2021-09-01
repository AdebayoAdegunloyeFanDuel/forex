package object_mapping_forex;

import config_management.ConfigManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ForexDesTests {
    private static ForexRatesDeserialiser forexRatesDes;

    @BeforeAll
    private static void setup(){
        forexRatesDes = new ForexRatesDeserialiser(new File(ConfigManager.ratesTestFileLocation()));
    }

    @Test
    public void test(){
        System.out.println(forexRatesDes.forexJsonDTO.isSuccess());
    }
}
