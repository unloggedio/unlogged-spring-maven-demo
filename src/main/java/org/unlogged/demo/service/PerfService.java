package org.unlogged.demo.service;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unlogged.demo.models.CustomerProfile;
import org.unlogged.demo.models.CustomerProfileRequest;
import org.unlogged.demo.models.weather.WeatherInfo;
import org.unlogged.demo.jspdemo.wfm.Models.Entities.User;
import org.unlogged.demo.jspdemo.wfm.Services.UserService;

import java.util.LinkedList;
import java.util.List;

import static org.unlogged.demo.OtelConfig.makeSpan;

@Service
public class PerfService {

    private final Tracer tracer = GlobalOpenTelemetry.getTracer("unlogged-spring-maven-demo");

    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserService userService;

    @Autowired
    private WeatherService weatherService;

    public long getCpuIntensiveData(long value) {
        Span span = tracer.spanBuilder("custom_tracer").startSpan();
        makeSpan(span, "input.value", value);

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

        makeSpan(span, "output", count);
        span.end();
        return count;
    }

    public long sum_natural(int count) {
        Span span = tracer.spanBuilder("custom_tracer").startSpan();
        makeSpan(span, "input.count", count);

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

        makeSpan(span, "output", sum);
        span.end();
        return sum;
    }

    public String readWriteInMemory(int count) {
        Span span = tracer.spanBuilder("custom_tracer").startSpan();
        makeSpan(span, "input.count", count);
        int span_count = 0;

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

            makeSpan(span, "mockData." + span_count, customerProfileRequest);
            span_count++;

            customerService.saveNewCustomer(customerProfileRequest);
        }

        StringBuilder customerData = new StringBuilder();
        for (int i=1;i<=count;i++) {
            CustomerProfile customerProfile = customerService.fetchCustomerProfile(i);

            makeSpan(span, "mockData." + span_count, customerProfile);
            span_count++;

            customerData.append(customerProfile.toString()).append("\n");
        }

        String s = customerData.toString();
        makeSpan(span, "output", s);
        span.end();
        return s;
    }

    public String genManyNetworkCall(int count) {

        int mockCount = 0;
        Span span = tracer.spanBuilder("custom_tracer").startSpan();
        makeSpan(span, "input.count", count);

        StringBuilder weatherData = new StringBuilder();
        for (int i=0;i<=count-1;i++) {
            WeatherInfo weatherInfo = weatherService.getWeatherForAddress("Bengaluru");

            makeSpan(span, "mockData." + mockCount, weatherInfo);
            mockCount++;

            weatherData.append(weatherInfo.toString()).append("\n");
        }

        String s = weatherData.toString();
        makeSpan(span, "output", s);
        span.end();
        return s;
    }

    public String genDatabaseIntensive(int count) {
        Span span = tracer.spanBuilder("custom_tracer").startSpan();
        makeSpan(span, "input.count", count);
        int mockCount = 0;

        // get base user id
        long baseId = userService.getCountOfUsers();
        makeSpan(span, "mockData." + mockCount, baseId);
        mockCount++;

        // read to the database
        for (int i=0;i<=count-1;i++) {
            long userId = baseId + i;
            User user = new User(
                    userId,
                    "username-" + userId,
                    "password-" + userId,
                    "mail-" + userId
            );
            makeSpan(span, "mockData." + mockCount, user);
            mockCount++;

            userService.addUser(user);
        }

        // read from the database
        StringBuilder dbResult = new StringBuilder();
        for (int i=0;i<=count-1;i++) {
            User user = userService.getUser(baseId + i);

            makeSpan(span, "mockData." + mockCount, user);
            mockCount++;

            dbResult.append(user.toString());
            makeSpan(span, "mockData." + mockCount, user.toString());
            mockCount++;
        }

        String val = dbResult.toString();
        makeSpan(span, "output", val);
        span.end();
        return val;
    }
	
}
