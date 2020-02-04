package org.apache.http.examples.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.DataInput;
import java.io.File;
import java.io.IOException;
import java.net.URL;


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

    public String getGetUsersSrvUrl() {
        return getUsersSrvUrl;
    }



    public final static void main(String[] args) throws Exception {


        ObjectMapper mapper = new ObjectMapper();


            URL url = new URL("https://vpp.itunes.apple.com/WebObjects/MZFinance.woa/wa/VPPServiceConfigSrv");
            ClientWithResponseHandler clientWithResponseHandler = null;
            String prettyStaff = null;
            String a = null;
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
                    }
                }
            }


        }catch (IOException e) {
            e.printStackTrace();
        }


        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpget = new HttpGet(a);

            System.out.println("Executing request " + httpget.getRequestLine());


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
        } finally {
            httpclient.close();
        }
    }

}
