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
@RequestMapping("/perf_analysis")
public class perfAnalysis {

    private int count_prime_calc(long value) {
        // This is O(n^2) implementation for calculating the prime numbers from 1 to value
        // This uses brute force to calculate it, and is CPU intensive single-threaded operation

        int count = 0;
        for (long i=0;i<=value;i++) {
            Boolean isPrime = true;
            for (long j=2;j<=value-1;j++) {
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
        // TODO: add explanation

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

    private int customer_count;

    @RequestMapping("/ping")
    public String ping() {
        return "server up!";
    }

    @RequestMapping("/cpu_intensive")
    public int cpu_intensive(@RequestParam long value) {
        return count_prime_calc(value);
    }

    @RequestMapping("/memory_intensive")
    public String memory_intensive(@RequestParam int count) {
        // TODO: split it in two parts (write values and read values)

        List<Long> val = sum_natural(count);
        long time_write = val.get(0);
        long time_read = val.get(1);
        long sum = val.get(2);

        String value = "write time = " + time_write + ". read time = " + time_read + ". sum = " + sum  + ".";
        return value;
    }

    @RequestMapping("/database_write_intensive")
    public String database_write_intensive(@RequestParam int customer_count) {
        this.customer_count = customer_count;
        for (int i=0;i<=customer_count-1;i++){

            String customerName = "name-" + customer_count;
            String customerDOB = "dob-" + customer_count;
            String customerEMail = "email-" + customer_count;
            String customerPrimaryNumber = "primaryNumber-" + customer_count;
            String customerAddress = "address-" + customer_count;
            CustomerProfileRequest customerProfileRequest = new CustomerProfileRequest(
                    customerName,
                    customerDOB,
                    customerEMail,
                    customerPrimaryNumber,
                    customerAddress);
            customerService.saveNewCustomer(customerProfileRequest);
        }

        String response_string = customer_count + "customer added successfully";
        return response_string;
    }

    @RequestMapping("/database_read_intensive")
    public String database_read_intensive() {

        StringBuilder customerData = new StringBuilder();
        for (int i=0;i<=this.customer_count;i++) {
            CustomerProfile customerProfile = customerService.fetchCustomerProfile(i);
            customerData.append(customerProfile.toString()).append("\n");
        }

        return customerData.toString();
    }

    @RequestMapping("/network_read_intensive")
    public String network_read_intensive() {

        StringBuilder weatherData = new StringBuilder();
        for (int i=0;i<=50;i++) {
            WeatherService weatherService = new WeatherService();
            WeatherInfo weatherInfo = weatherService.getWeatherForAddress("Bengaluru");
            weatherData.append(weatherInfo.toString()).append("\n");
        }

        return weatherData.toString();
    }

}
