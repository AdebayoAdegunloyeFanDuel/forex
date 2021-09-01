package config_management;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    // Preparing our private variable for our Properties object initialization
    private static final Properties config;
    /*
    We are using a static block to initialise our static properties
    instantiation and set our reader

    It is very similar to what we do when initialising a normal class
    i.e public ConfigManager(){}

    Using a static block means that when we run/build our program this block is immediately loaded referred
    to as Eagerly loading/loaded
     */

    static {
        // Instantiate of our Properties object - Properties object is there to work with .properties files
        config = new Properties();
        try {
            // loading the config file using newly instantiated FileReader
            config.load(new FileReader("src/test/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String ratesTestFileLocation(){

        return config.getProperty("rates_test_file_location");
    }

    public static String fixerBaseUrl(){
        return config.getProperty("base_url");
    }

    public static String accessQueryParamValue(){
        return config.getProperty("access_key_param");
    }

    public static String LatestServiceEndPoint(){
        return config.getProperty("latest_service_endpoint");
    }

    public static String accessKey(){
        return config.getProperty("access_key");
    }

    public static String testEnv(){
        return config.getProperty("test_env");
    }

}
