package org.unlogged.demo.jspdemo.wfm.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.unlogged.demo.jspdemo.wfm.ApiHelper.WeatherApi;
import org.unlogged.demo.jspdemo.wfm.Models.Entities.MessageDto;

import java.io.IOException;
import java.util.Map;

@RestController
public class GcdController {

    @Autowired
    private WeatherApi weatherApi;

    public MessageDto gcdOfTwoNumbers(int n1, int n2) throws IOException {
        while (n1 != n2) {
            if (n1 > n2)
                n1 = n1 - n2;
            else
                n2 = n2 - n1;
        }
        String weather2 = "";
        MessageDto messageDto = new MessageDto();
        if (n1 > 19) {
            weather2 = weatherApi.getWeatherinfo("London");
        } else {
            weather2 = weatherApi.getWeatherinfo("Pune");
        }
        messageDto.setWeather(weather2);
        if (n2 < 5) {
            messageDto.setGcd(n2 + 10);
        } else {
            messageDto.setGcd(n2 + 5);
        }
        return messageDto;
    }

    public String getNull() {
        return null;
    }
}
