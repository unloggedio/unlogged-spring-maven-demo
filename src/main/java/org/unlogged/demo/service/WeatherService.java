package org.unlogged.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unlogged.demo.models.weather.WeatherInfo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class WeatherService {

    private final Tracer tracer = GlobalOpenTelemetry.getTracer("unlogged-spring-maven-demo");

    public WeatherInfo getWeatherForAddress(String address) {
        Span span = tracer.spanBuilder("custom_tracer").startSpan();
        span.setAttribute("input.address", address);

        WeatherInfo weatherInfo = convertToObject(getWeatherinfo(address));
        span.setAttribute("mockData.1", weatherInfo.toString());

        span.setAttribute("output", weatherInfo.toString());
        span.end();
        return weatherInfo;
    }

    public WeatherInfo convertToObject(String info) {
        Span span = tracer.spanBuilder("custom_tracer").startSpan();
        span.setAttribute("input.info", info);

        ObjectMapper om = new ObjectMapper();
        try {
            WeatherInfo weatherInfo = om.readValue(info, WeatherInfo.class);

            span.setAttribute("output", weatherInfo.toString());
            span.end();
            return weatherInfo;
        } catch (Exception e) {

            span.setAttribute("output", "exception");
            span.end();
            return null;
        }
    }

    private String getWeatherinfo(String location) {
        Span span = tracer.spanBuilder("custom_tracer").startSpan();
        span.setAttribute("input.location", location);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://api.weatherapi.com/v1/current.json?key=09282a8b683349e79f852552230102&q=" + location + "&aqi=no"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            span.setAttribute("mockData.1", response.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String s = response.body();
        span.setAttribute("output", s);
        span.end();
        return s;
    }

    public String getLocationFromAddress(String address) {
        String[] parts = address.split(" ");
        if (parts.length >= 1) {
            return parts[parts.length - 1];
        }
        return address;
    }
}
