package org.unlogged.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.unlogged.demo.models.weather.WeatherInfo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class WeatherService {

    public WeatherInfo getWeatherForAddress(String address) {
        return convertToObject(getWeatherinfo(address));
    }

    public WeatherInfo convertToObject(String info) {
        ObjectMapper om = new ObjectMapper();
        try {
            WeatherInfo weatherInfo = om.readValue(info, WeatherInfo.class);
            return weatherInfo;
        } catch (Exception e) {
            return null;
        }
    }

    private String getWeatherinfo(String location) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://api.weatherapi.com/v1/current.json?key=09282a8b683349e79f852552230102&q=" + location + "&aqi=no"))
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

    public String getLocationFromAddress(String address) {
        String[] parts = address.split(" ");
        if (parts.length >= 1) {
            return parts[parts.length - 1];
        }
        return address;
    }
}
