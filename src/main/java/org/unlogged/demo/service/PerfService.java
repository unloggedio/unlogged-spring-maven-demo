package org.unlogged.demo.service;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unlogged.demo.jspdemo.wfm.Models.Entities.BigPojo;
import org.unlogged.demo.models.CustomerProfile;
import org.unlogged.demo.models.CustomerProfileRequest;
import org.unlogged.demo.models.weather.WeatherInfo;
import org.unlogged.demo.jspdemo.wfm.Models.Entities.User;
import org.unlogged.demo.jspdemo.wfm.Services.UserService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.unlogged.demo.OtelConfig.makeSpan;
import static org.unlogged.demo.OtelConfig.registerMethod;

@Service
public class PerfService {

    private static final Tracer tracer = GlobalOpenTelemetry.getTracer("unlogged-spring-maven-demo");

    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserService userService;

    @Autowired
    private WeatherService weatherService;

    public long getCpuIntensiveData(long value) {
        Span span = tracer.spanBuilder("custom_tracer.8").startSpan();
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

        span.end();
        return count;
    }

    public long sum_natural(int count) {
        Span span = tracer.spanBuilder("custom_tracer.9").startSpan();
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

        span.end();
        return sum;
    }

    public String readWriteInMemory(int count) {
        Span span = tracer.spanBuilder("custom_tracer.10").startSpan();
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
        Span span = tracer.spanBuilder("custom_tracer.11").startSpan();
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
        Span span = tracer.spanBuilder("custom_tracer.12").startSpan();
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

    public String dataIntensive(ArrayList<BigPojo> dataList) {

        int mockCount = 0;
        Span span = tracer.spanBuilder("custom_tracer.13").startSpan();
        makeSpan(span, "input", dataList);

        int n = dataList.size();
        makeSpan(span, "mockData." + mockCount, n);
        mockCount++;

        StringBuilder listString = new StringBuilder();
        for (int i=0;i<=n-1;i++) {
            listString.append(dataList.get(i).toString());

            makeSpan(span, "mockData." + mockCount, dataList.get(i));
            mockCount++;

            makeSpan(span, "mockData." + mockCount, dataList.get(i).toString());
            mockCount++;
        }

        String s = listString.toString();
        makeSpan(span, "mockData." + mockCount, s);
        mockCount++;
        span.end();
        return s;
    }

    static {
        Span span = tracer.spanBuilder("method_registration").startSpan();
        registerMethod(span, 8, "org.unlogged.demo.service.PerfService", "getCpuIntensiveData", "J", "J", false, true, true, 1, "(J)J");
        registerMethod(span, 9, "org.unlogged.demo.service.PerfService", "sum_natural", "I", "J", false, true, true, 1, "(I)J");
        registerMethod(span, 10, "org.unlogged.demo.service.PerfService", "readWriteInMemory", "I", "java.lang.String", false, true, true, 1, "(I)Ljava/lang/String;");
        registerMethod(span, 11, "org.unlogged.demo.service.PerfService", "genManyNetworkCall", "I", "java.lang.String", false, true, true, 1, "(I)Ljava/lang/String;");
        registerMethod(span, 12, "org.unlogged.demo.service.PerfService", "genDatabaseIntensive", "I", "java.lang.String", false, true, true, 1, "(I)Ljava/lang/String;");
        registerMethod(span, 13, "org.unlogged.demo.service.PerfService", "dataIntensive", "java.util.ArrayList", "java.lang.String", false, true, true, 1, "(Ljava/util/ArrayList;)Ljava/lang/String;");
        span.end();
    }

}
