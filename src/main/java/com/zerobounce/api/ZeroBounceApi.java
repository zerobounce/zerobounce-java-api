package com.zerobounce.api;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ZeroBounceApi {
    private final String apiKey;
    private final String baseUrl = "https://api.zerobounce.net/v1";
    private final HttpClient httpClient = HttpClients.custom().build();

    /**
     * Get an instance of the API helper class
     * @param apiKey - your private API key
     */
    public ZeroBounceApi(String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * @return - the number of credits remaining on your account
     * @throws IOException
     * @throws URISyntaxException
     */
    public int getCredits() throws IOException, URISyntaxException {
        URI uri = new URIBuilder(baseUrl + "/getcredits")
                .addParameter("apikey", this.apiKey)
                .build();
        HttpGet httpGet = new HttpGet(uri);

        HttpResponse httpResponse = httpClient.execute(httpGet);

        if (httpResponse.getStatusLine().getStatusCode() != 200) {
            throw new IllegalStateException(httpResponse.getStatusLine().getStatusCode() + " - " + EntityUtils.toString(httpResponse.getEntity()));
        } else {
            return new JSONObject(EntityUtils.toString(httpResponse.getEntity())).getInt("Credits");
        }
    }

    /**
     * @param email - the email you want to validate
     * @return - a JSONObject with all of the information for the specified email
     * @throws IOException
     * @throws URISyntaxException
     */
    public JSONObject validate(String email) throws IOException, URISyntaxException {
        URI uri = new URIBuilder(baseUrl + "/validate")
                .addParameter("apikey", this.apiKey)
                .addParameter("email", email)
                .build();

        HttpGet httpGet = new HttpGet(uri);
        HttpResponse httpResponse = httpClient.execute(httpGet);

        if (httpResponse.getStatusLine().getStatusCode() != 200) {
            throw new IllegalStateException(httpResponse.getStatusLine().getStatusCode() + " - " + EntityUtils.toString(httpResponse.getEntity()));
        } else {
            return new JSONObject(EntityUtils.toString(httpResponse.getEntity()));
        }
    }

    /**
     * @param email - the email you want to validate
     * @param ip - the ip to be use for this validation (advanced)
     * @return - a JSONObject with all of the information for the specified email
     * @throws IOException
     * @throws URISyntaxException
     */
    public JSONObject validateWithIpAddress(String email, String ip) throws IOException, URISyntaxException {
        URI uri = new URIBuilder(baseUrl + "/validatewithip")
                .addParameter("apikey", this.apiKey)
                .addParameter("email", email)
                .addParameter("ipAddress", ip)
                .build();

        HttpGet httpGet = new HttpGet(uri);
        HttpResponse httpResponse = httpClient.execute(httpGet);

        if (httpResponse.getStatusLine().getStatusCode() != 200) {
            throw new IllegalStateException(httpResponse.getStatusLine().getStatusCode() + " - " + EntityUtils.toString(httpResponse.getEntity()));
        } else {
            return new JSONObject(EntityUtils.toString(httpResponse.getEntity()));
        }
    }
}
