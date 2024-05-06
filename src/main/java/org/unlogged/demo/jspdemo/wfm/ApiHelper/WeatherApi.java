package org.unlogged.demo.jspdemo.wfm.ApiHelper;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.unlogged.demo.KindOfAUtilClass;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;


@Service
public class WeatherApi {
    public String getWeatherinfo(String location) {

        try {
            URL url = new URL("\"http://api.weatherapi.com/v1/current.json?key=09282a8b683349e79f852552230102&q=\" + location + \"&aqi=no\"");
            URLConnection con = url.openConnection();
            HttpURLConnection http = (HttpURLConnection) con;
            http.setRequestMethod("GET");
            http.setDoOutput(true);

            InputStream is = http.getInputStream();
            String response = IOUtils.toString(is, StandardCharsets.UTF_8);
            System.out.println("Response from API : " + response);
        } catch (Exception e) {

        }
        return null;
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
