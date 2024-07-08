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

import static org.unlogged.demo.OtelConfig.makeSpan;
import static org.unlogged.demo.OtelConfig.registerMethod;

@Service
public class WeatherService {

    private static final Tracer tracer = GlobalOpenTelemetry.getTracer("unlogged-spring-maven-demo");

    public WeatherInfo getWeatherForAddress(String address) {
        Span span = tracer.spanBuilder("custom_tracer.16").startSpan();
        makeSpan(span, "input.address", address);

        WeatherInfo weatherInfo = convertToObject(getWeatherinfo(address));
        makeSpan(span, "mockData.1", weatherInfo);

        makeSpan(span, "output", weatherInfo);
        span.end();
        return weatherInfo;
    }

    public WeatherInfo convertToObject(String info) {
        Span span = tracer.spanBuilder("custom_tracer.17").startSpan();
        makeSpan(span, "input.info", info);

        ObjectMapper om = new ObjectMapper();
        try {
            WeatherInfo weatherInfo = om.readValue(info, WeatherInfo.class);

            makeSpan(span, "output", weatherInfo);
            span.end();
            return weatherInfo;
        } catch (Exception e) {

            makeSpan(span, "output", "exception");
            span.end();
            return null;
        }
    }

    private String getWeatherinfo(String location) {
        Span span = tracer.spanBuilder("custom_tracer.18").startSpan();
        makeSpan(span, "input.location", location);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://api.weatherapi.com/v1/current.json?key=09282a8b683349e79f852552230102&q=" + location + "&aqi=no"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            makeSpan(span, "mockData.1", response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String s = response.body();
        makeSpan(span, "output", s);
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

    static {
        Span span = tracer.spanBuilder("method_registration").startSpan();
        registerMethod(span, 16, "org.unlogged.demo.service.WeatherService", "getWeatherForAddress", "java.lang.String", "org.unlogged.demo.models.weather.WeatherInfo", false, true, true, 1, "(Ljava/lang/String;)Lorg/unlogged/demo/models/weather/WeatherInfo;");
        registerMethod(span, 17, "org.unlogged.demo.service.WeatherService", "convertToObject", "java.lang.String", "org.unlogged.demo.models.weather.WeatherInfo", false, true, true, 1, "(Ljava/lang/String;)Lorg/unlogged/demo/models/weather/WeatherInfo;");
        registerMethod(span, 18, "org.unlogged.demo.service.WeatherService", "getWeatherinfo", "java.lang.String", "java.lang.String", false, false, true, 2, "(Ljava/lang/String;)Ljava/lang/String;");
        span.end();
    }
}
