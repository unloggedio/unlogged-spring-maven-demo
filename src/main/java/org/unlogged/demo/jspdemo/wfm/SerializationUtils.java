package org.unlogged.demo.jspdemo.wfm;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.unlogged.demo.jspdemo.wfm.ApiHelper.WeatherInfo;

public class SerializationUtils {

    public static WeatherInfo getObjectFor(String info) throws Exception {
        ObjectMapper om = new ObjectMapper();
        WeatherInfo weatherInfo = om.readValue(info, WeatherInfo.class);
        return weatherInfo;
    }
}
