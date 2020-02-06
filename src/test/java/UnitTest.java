import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.examples.client.Parser;
import org.apache.http.examples.client.ClientWithResponseHandler;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.*;


public class UnitTest {


    @Test
    public void testjson(){


        File file = new File("src/test/resources/test.json");
        Parser parser = new Parser();
        String b = parser.par(file);
        assertEquals("https://vpp.itunes.apple.com/mdm/getVPPUsersSrv",b);

    }
}