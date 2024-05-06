package org.unlogged.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unlogged.demo.jspdemo.wfm.ApiHelper.WeatherApi;
import org.unlogged.demo.models.weather.WeatherInfo;

@Service
public class WeatherService {

    @Autowired
    private WeatherApi weatherApi;

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
        return weatherApi.getWeatherinfo(location);
    }

    public String getLocationFromAddress(String address) {
        String[] parts = address.split(" ");
        if (parts.length >= 1) {
            return parts[parts.length - 1];
        }
        return address;
    }
}
