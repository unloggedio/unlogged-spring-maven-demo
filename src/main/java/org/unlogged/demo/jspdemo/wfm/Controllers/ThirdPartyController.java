package org.unlogged.demo.jspdemo.wfm.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.unlogged.demo.jspdemo.wfm.ApiHelper.WeatherInfo;
import org.unlogged.demo.jspdemo.wfm.ThirdPartyService;

@RestController
@RequestMapping("/tpc")
public class ThirdPartyController {

    @Autowired
    ThirdPartyService thirdPartyService;

    @RequestMapping(value = "/weather", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WeatherInfo> getResponse(@RequestParam String location) throws Exception {
        WeatherInfo info = thirdPartyService.getWeatherFor(location);
        return ResponseEntity.ok(info);

    }

    @RequestMapping(value = "/weather/bangalore", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WeatherInfo> getWeatherForBangalore() throws Exception {
        return ResponseEntity.ok(thirdPartyService.getWeatherFor("Bangalore"));
    }
}
