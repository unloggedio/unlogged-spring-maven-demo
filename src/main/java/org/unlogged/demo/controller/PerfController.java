package org.unlogged.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.unlogged.demo.models.CustomerProfile;
import org.unlogged.demo.models.CustomerProfileRequest;
import org.unlogged.demo.models.PerfData;
import org.unlogged.demo.models.weather.WeatherInfo;
import org.unlogged.demo.service.CustomerService;
import org.unlogged.demo.service.PerfService;
import org.unlogged.demo.service.WeatherService;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


// TODO: return values in JSON
// TODO: add explanation

@RestController
@RequestMapping("/perf")
public class PerfController {

	@Autowired
    private PerfService perfService;

    @RequestMapping("/ping")
    public String ping() {
        return "server up!";
    }

    @RequestMapping("/cpuintensive")
    public long cpu(@RequestParam long value) {
        return perfService.getCpuIntensiveData(value);
    }

    @RequestMapping("/memoryintensive")
    public long memoryIntensive(@RequestParam int count) {
        long sum = perfService.sum_natural(count);
        return sum;
    }

    @RequestMapping("/databaseintensive")
    public String databaseintensive(@RequestParam int count) {
        return perfService.readWriteInDatabase(count);
    }

    @RequestMapping("/networkintensive")
    public String networkintensive(@RequestParam int count) {
		
		long timestamp_1 = System.currentTimeMillis();
        StringBuilder weatherData = new StringBuilder();
        for (int i=0;i<=count-1;i++) {
            WeatherService weatherService = new WeatherService();
            WeatherInfo weatherInfo = weatherService.getWeatherForAddress("Bengaluru");
            weatherData.append(weatherInfo.toString()).append("\n");
        }
		long timestamp_2 = System.currentTimeMillis();

		long time_write = timestamp_2 - timestamp_1;
		String response = count + "request completed.\n time_write = " + time_write + ".\n weather_data = " + weatherData.toString();
        return response;
    }

}
