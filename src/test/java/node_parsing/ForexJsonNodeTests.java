package node_parsing;

import config_management.ConfigManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ForexJsonNodeTests {
    private static ForexJsonNodeParsing forexJsonNodeParsing;

    @BeforeAll
    private static void setup(){
        forexJsonNodeParsing = new ForexJsonNodeParsing(new File(ConfigManager.ratesTestFileLocation()));
    }

    @Test
    public void TestForexSuccessStatus(){
        assertTrue(forexJsonNodeParsing.getSuccess());
    }

    @Test
    public void TestForexBase(){
        assertEquals("EUR", forexJsonNodeParsing.getBase());
    }

    @Test
    public void dateMatchesTimestampTest(){
        long epoch = Long.parseLong( Integer.toString( forexJsonNodeParsing.getTimestamp() ));
        Date date = new Date( epoch * 1000 );
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = format.format( date );
        assertEquals( formattedDate, forexJsonNodeParsing.getDate());
    }
}
