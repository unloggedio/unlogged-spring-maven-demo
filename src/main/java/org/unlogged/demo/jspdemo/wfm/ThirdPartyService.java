package org.unlogged.demo.jspdemo.wfm;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.unlogged.demo.jspdemo.wfm.ApiHelper.WeatherInfo;

@Component
@Service
public class ThirdPartyService {
    ThirdPartyApiHelper helper = new ThirdPartyApiHelper();
    public WeatherInfo getWeatherFor(String location) throws Exception {
        String info = helper.getWeatherinfo(location);
        return SerializationUtils.getObjectFor(info);
    }
}
