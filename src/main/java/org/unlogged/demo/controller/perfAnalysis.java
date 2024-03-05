package org.unlogged.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.unlogged.demo.models.CustomerProfile;
import org.unlogged.demo.models.CustomerProfileRequest;
import org.unlogged.demo.models.weather.WeatherInfo;
import org.unlogged.demo.service.CustomerService;
import org.unlogged.demo.service.WeatherService;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/perf")
public class perfAnalysis {

	// TODO: return values in JSON
	// TODO: add explanation
    private int count_prime_calc(long value) {
        // This is O(n^2) implementation for calculating the prime numbers from 1 to value
        // This uses brute force to calculate it, and is CPU intensive single-threaded operation

        int count = 0;
        for (long i=2;i<=value;i++) {
            Boolean isPrime = true;
            for (long j=2;j<=i-1;j++) {
                if (i%j == 0) {
                    isPrime = false;
                }
            }

            if (isPrime) {
                count++;
            }
        }
        return count;
    }

    private List<Long> sum_natural(int count) {
        

        long timestamp_1 = System.currentTimeMillis();

        // write value to memory
        List<Integer> value_list = new LinkedList<>();
        for (int i=0;i<=count-1;i++) {
            value_list.add( i);
        }
        long timestamp_2 = System.currentTimeMillis();

        // read value from memory
        long sum=0;
        for (int i=0;i<value_list.size()-1;i++) {
            sum += value_list.get(i);
        }
        long timestamp_3 = System.currentTimeMillis();

        long time_write = timestamp_2 - timestamp_1;
        long time_read = timestamp_3 - timestamp_2;
        List<Long> val = Arrays.asList(time_write, time_read, sum);
        return val;
    }

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/ping")
    public String ping() {
        return "server up!";
    }

    @RequestMapping("/cpuintensive")
    public int cpu(@RequestParam int value) {
        return count_prime_calc(value);
    }

    @RequestMapping("/memoryintensive")
    public String memoryIntensive(@RequestParam int count) {

        List<Long> val = sum_natural(count);
        long time_write = val.get(0);
        long time_read = val.get(1);
        long sum = val.get(2);

        String value = "write time = " + time_write + ". read time = " + time_read + ". sum = " + sum  + ".";
        return value;
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
