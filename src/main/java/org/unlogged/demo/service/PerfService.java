package org.unlogged.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unlogged.demo.jspdemo.wfm.Models.Entities.User;
import org.unlogged.demo.jspdemo.wfm.Services.UserService;
import org.unlogged.demo.models.CustomerProfile;
import org.unlogged.demo.models.CustomerProfileRequest;
import org.unlogged.demo.models.weather.WeatherInfo;

import java.util.LinkedList;
import java.util.List;

@Service
public class PerfService {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserService userService;

    public long getCpuIntensiveData(long value) {

        // This is O(n^2) implementation for calculating the prime numbers from 1 to value
        // This uses brute force to calculate it, and is CPU intensive single-threaded operation
        long count = 0;
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

    public long sum_natural(int count) {

        // write value to memory
        List<Integer> value_list = new LinkedList<>();
        for (int i=0;i<=count-1;i++) {
            value_list.add(i);
        }

        // read value from memory
        long sum=0;
        for (int i=0;i<value_list.size()-1;i++) {
            sum += value_list.get(i);
        }

        return sum;
    }

    public String readWriteInMemory(int count) {

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

        StringBuilder customerData = new StringBuilder();
        for (int i=1;i<=count;i++) {
            CustomerProfile customerProfile = customerService.fetchCustomerProfile(i);
            customerData.append(customerProfile.toString()).append("\n");
        }

        return customerData.toString();
    }

    public String genManyNetworkCall(int count) {

        StringBuilder weatherData = new StringBuilder();
        for (int i=0;i<=count-1;i++) {
            WeatherService weatherService = new WeatherService();
            WeatherInfo weatherInfo = weatherService.getWeatherForAddress("Bengaluru");
            weatherData.append(weatherInfo.toString()).append("\n");
        }

        return weatherData.toString();
    }

    public String genDatabaseIntensive(int count) {
        // get base user id
        long baseId = userService.getCountOfUsers();

        // read to the database
        for (int i=0;i<=count-1;i++) {
            long userId = baseId + i;
            User user = new User(
                    userId,
                    "username-" + userId,
                    "password-" + userId,
                    "mail-" + userId
            );

            userService.addUser(user);
        }

        // read from the database
        StringBuilder dbResult = new StringBuilder();
        for (int i=0;i<=count-1;i++) {
            User user = userService.getUser(baseId + i);
            dbResult.append(user.toString());
        }

        return dbResult.toString();
    }
	
}
