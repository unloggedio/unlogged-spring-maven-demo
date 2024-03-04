package org.unlogged.demo.jspdemo.wfm;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import org.unlogged.demo.jspdemo.wfm.ApiHelper.WeatherInfo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ThirdPartyApiHelper {

    public String getWeatherinfo(String location)
    {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://api.weatherapi.com/v1/current.json?key=09282a8b683349e79f852552230102&q="+location+"&aqi=no"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response.body();
    }

    private WeatherInfo convert(String response)
    {
        try {
            ObjectMapper om = new ObjectMapper();
            WeatherInfo root = om.readValue(response, WeatherInfo.class);
            return root;
        }
        catch (Exception e)
        {
            System.out.println("Exception parsing json "+e);
            e.printStackTrace();
        }
        return null;
    }

    private String filter(String json)
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(json);
        String prettyJsonString = gson.toJson(je);
        return prettyJsonString;
    }

    private JsonElement getObject(String json)
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(json);
        return je;
    }
}

