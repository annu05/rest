package org.apache.http.examples.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;



@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientWithResponseHandler {

    @JsonProperty("getUsersSrvUrl")
    private String getUsersSrvUrl;
    @JsonProperty("getLicensesSrvUrl")
    private String getLicensesSrvUrl;

    public String getGetUsersSrvUrl() {
        return getUsersSrvUrl;
    }



    public final static void main(String[] args) throws Exception {


        ObjectMapper mapper = new ObjectMapper();


            URL url = new URL("https://vpp.itunes.apple.com/WebObjects/MZFinance.woa/wa/VPPServiceConfigSrv");
            ClientWithResponseHandler clientWithResponseHandler = null;
            String prettyStaff = null;
            String a = null;
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

        String stoken = "eyJleHBEYXRlIjoiMjAyMC0wOS0xNVQyMzoxNToxNi0wNzAwIiwidG9rZW4iOiI5c3RtRTcvbWFuckxJZExqcU1DeXpjaXM2S1BxZ0p3blVha1JMditVN0swdlF1RTQvWDIwdkNYeXd2U3pwZXpZQk05d3B0M0Z0bVYrSExXYldlcVRWdUhmaWxzL050ajZ1OTgzdktPckFjbkNBOHlvN0VDV09IQ1o3bm1kSDFMK09zVzdJeThUVlZ5MkNWS0JXZGVOZEE9PSIsIm9yZ05hbWUiOiJOb3ZlbGwifQhttps://uclient-api.itunes.apple.com/WebObjects/MZStorePlatform.woa/wa/lookup?version=2";
        String stoken2 = "?sToken=eyJleHBEYXRlIjoiMjAyMC0wOS0xNVQyMzoxNToxNi0wNzAwIiwidG9rZW4iOiI5c3RtRTcvbWFuckxJZExqcU1DeXpjaXM2S1BxZ0p3blVha1JMditVN0swdlF1RTQvWDIwdkNYeXd2U3pwZXpZQk05d3B0M0Z0bVYrSExXYldlcVRWdUhmaWxzL050ajZ1OTgzdktPckFjbkNBOHlvN0VDV09IQ1o3bm1kSDFMK09zVzdJeThUVlZ5MkNWS0JXZGVOZEE9PSIsIm9yZ05hbWUiOiJOb3ZlbGwifQ==&clientUserIdStr=100001";

        URL url2 = new URL(a+"?sToken="+stoken);
        Test test = null;
        String prettyStaff2 = null;
        String a2 = null;
        String b2 = null;
        JsonParser parser2;
        try{
            test =mapper.readValue(url2,Test.class);

            prettyStaff2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(test);
            System.out.println(prettyStaff2);

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

        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpget = new HttpGet(a+"?sToken="+stoken);
            HttpGet httpget2 = new HttpGet(b+stoken2);

            System.out.println("Executing request " + httpget.getRequestLine());
            System.out.println("Executing request " + httpget2.getRequestLine());


            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

                @Override
                public String handleResponse(
                        final HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }

            };
            String responseBody = httpclient.execute(httpget, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
            String responseBody2 = httpclient.execute(httpget2, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody2);
        } finally {
            httpclient.close();
        }
        App app = new App();
        app.connect();
    }






}

