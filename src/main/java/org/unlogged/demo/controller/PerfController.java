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
    private CustomerService customerService;

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

		long timestamp_1 = System.currentTimeMillis();
        for (int i=0;i<=count-1;i++){

            String customerName = "name-" + count;
            String customerDOB = "dob-" + count;
            String customerEMail = "email-" + count;
            String customerPrimaryNumber = "primaryNumber-" + count;
            String customerAddress = "address-" + count;
            CustomerProfileRequest customerProfileRequest = new CustomerProfileRequest(
                    customerName,
                    customerDOB,
                    customerEMail,
                    customerPrimaryNumber,
                    customerAddress);
			customerService.saveNewCustomer(customerProfileRequest);
        }
		long timestamp_2 = System.currentTimeMillis();

        StringBuilder customerData = new StringBuilder();
        for (int i=1;i<=count;i++) {
            CustomerProfile customerProfile = customerService.fetchCustomerProfile(i);
            customerData.append(customerProfile.toString()).append("\n");
        }
		long timestamp_3 = System.currentTimeMillis();

		long time_write = timestamp_2 - timestamp_1;
		long time_read = timestamp_3 - timestamp_2;
        String response_string = count + " customers write and read done.\n time_write = " + time_write + "\n time_read = " + time_read + 
		". \n customer_data = " + customerData.toString();
        return response_string;
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
