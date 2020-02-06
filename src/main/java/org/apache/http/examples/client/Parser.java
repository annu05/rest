package org.apache.http.examples.client;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Parser {
    public String a = null;
    public String c = null;
    public String d = null;
    public String e = null;

    public String par(URL url){

        ObjectMapper mapper = new ObjectMapper();



        ClientWithResponseHandler clientWithResponseHandler = null;
        String prettyStaff = null;
        Test test =null;
        String b = null;
        JsonParser parser;

        try{
            clientWithResponseHandler =mapper.readValue(url,ClientWithResponseHandler.class);
            test = mapper.readValue(url,Test.class);

            prettyStaff = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(clientWithResponseHandler);



            JsonFactory factory = new JsonFactory();
            parser  = factory.createParser(prettyStaff);


            while(!parser.isClosed()){
                JsonToken jsonToken = parser.nextToken();
                if(JsonToken.FIELD_NAME.equals(jsonToken)){
                    String fieldName = parser.getCurrentName();


                    jsonToken = parser.nextToken();


                    if("getUsersSrvUrl".equals(fieldName)){
                        a = parser.getValueAsString();
                    }
                }
            }


        }catch (IOException e) {
            e.printStackTrace();
        }
        return a;


    }

    public String par(File file){

        ObjectMapper mapper = new ObjectMapper();



        ClientWithResponseHandler clientWithResponseHandler = null;

        String prettyStaff = null;

        String b = null;
        JsonParser parser;
        try{
            clientWithResponseHandler =mapper.readValue(file,ClientWithResponseHandler.class);


            prettyStaff = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(clientWithResponseHandler);


            JsonFactory factory = new JsonFactory();
            parser  = factory.createParser(prettyStaff);


            while(!parser.isClosed()){
                JsonToken jsonToken = parser.nextToken();

                if(JsonToken.FIELD_NAME.equals(jsonToken)){
                    String fieldName = parser.getCurrentName();


                    jsonToken = parser.nextToken();


                    if("getUsersSrvUrl".equals(fieldName)){
                        a = parser.getValueAsString();
                    }
                }
            }


        }catch (IOException e) {
            e.printStackTrace();
        }
        return a;


    }




}
