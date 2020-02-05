package org.apache.http.examples.client;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Parser {
    public String a = null;
    public String par(){

        ObjectMapper mapper = new ObjectMapper();


        URL url = null;
        try {
            url = new URL("https://vpp.itunes.apple.com/WebObjects/MZFinance.woa/wa/VPPServiceConfigSrv");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        ClientWithResponseHandler clientWithResponseHandler = null;
        String prettyStaff = null;

        String b = null;
        JsonParser parser;
        try{
            clientWithResponseHandler =mapper.readValue(url,ClientWithResponseHandler.class);

            prettyStaff = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(clientWithResponseHandler);

            System.out.println(prettyStaff);
            JsonFactory factory = new JsonFactory();
            parser  = factory.createParser(prettyStaff);
            while(!parser.isClosed()){
                JsonToken jsonToken = parser.nextToken();
                if(JsonToken.FIELD_NAME.equals(jsonToken)){
                    String fieldName = parser.getCurrentName();


                    jsonToken = parser.nextToken();


                    if("getUsersSrvUrl".equals(fieldName)){
                        a = parser.getValueAsString();
                    }else if("getLicensesSrvUrl".equals(fieldName)){
                        b = parser.getValueAsString();
                    }
                }
            }


        }catch (IOException e) {
            e.printStackTrace();
        }
        return a;


    }
}
