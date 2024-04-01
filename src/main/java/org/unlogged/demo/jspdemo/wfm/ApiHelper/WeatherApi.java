package org.unlogged.demo.jspdemo.wfm.ApiHelper;

import org.springframework.stereotype.Service;
import org.unlogged.demo.KindOfAUtilClass;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class WeatherApi {
    public String getWeatherinfo(String location) {
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

    public void timeTake(float multiplier) throws InterruptedException {

        KindOfAUtilClass.thisMethodTakesTimeToCompleteBasedOnParameter((long) (1 * multiplier));
        KindOfAUtilClass.thisMethodTakesTimeToCompleteBasedOnParameter((long) (2 * multiplier));
        KindOfAUtilClass.thisMethodTakesTimeToCompleteBasedOnParameter((long) (5 * multiplier));
        KindOfAUtilClass.thisMethodTakesTimeToCompleteBasedOnParameter((long) (10 * multiplier));
        KindOfAUtilClass.thisMethodTakesTimeToCompleteBasedOnParameter((long) (20 * multiplier));
        KindOfAUtilClass.thisMethodTakesTimeToCompleteBasedOnParameter((long) (50 * multiplier));
        KindOfAUtilClass.thisMethodTakesTimeToCompleteBasedOnParameter((long) (100 * multiplier));
        KindOfAUtilClass.thisMethodTakesTimeToCompleteBasedOnParameter((long) (200 * multiplier));
        KindOfAUtilClass.thisMethodTakesTimeToCompleteBasedOnParameter((long) (500 * multiplier));
        KindOfAUtilClass.thisMethodTakesTimeToCompleteBasedOnParameter((long) (1000 * multiplier));
        KindOfAUtilClass.thisMethodTakesTimeToCompleteBasedOnParameter((long) (2000 * multiplier));
        KindOfAUtilClass.thisMethodTakesTimeToCompleteBasedOnParameter((long) (5000 * multiplier));
        KindOfAUtilClass.thisMethodTakesTimeToCompleteBasedOnParameter((long) (10000 * multiplier));


    }

}
