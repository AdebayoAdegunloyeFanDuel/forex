package object_mapping_forex;

import config_management.ConfigManager;
import http_management.FixerLatestRatesHttpMgr;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ForexDesTests {

    private static ForexJsonDTO forexRatesDes;

    @BeforeAll
    private static void setup(){
        if (ConfigManager.testEnv().equals("file")){
            forexRatesDes = new ForexRatesDeserialiser().fixerLatestRatesData(new File(ConfigManager.ratesTestFileLocation()));
        } else if (ConfigManager.testEnv().equals("http")){
            FixerLatestRatesHttpMgr fixerLatestRatesHttpMgr = new FixerLatestRatesHttpMgr();
            fixerLatestRatesHttpMgr.makeUrlCall();
            forexRatesDes = new ForexRatesDeserialiser().fixerLatestRatesData(new File(fixerLatestRatesHttpMgr.getResponseBody()));
        }
    }

    @Test
    public void test(){
        System.out.println(forexRatesDes.getDate());
    }
}
