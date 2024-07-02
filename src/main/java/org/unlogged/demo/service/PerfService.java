package org.unlogged.demo.service;

import com.google.j2objc.annotations.AutoreleasePool;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unlogged.demo.models.CustomerProfile;
import org.unlogged.demo.models.CustomerProfileRequest;
import org.unlogged.demo.models.PerfData;
import org.unlogged.demo.models.weather.WeatherInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Service
public class PerfService {

    private final Tracer tracer;

    @Autowired
    public PerfService(Tracer tracer) {
        this.tracer = tracer;
    }

    @Autowired
    private CustomerService customerService;

    @Autowired
    private WeatherService weatherService;

    public long getCpuIntensiveData(long value) {
        Span span = tracer.spanBuilder("custom_tracer").startSpan();
        span.setAttribute("input.value", value);

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

        span.setAttribute("output", count);
        span.end();
        return count;
    }

    public long sum_natural(int count) {
        Span span = tracer.spanBuilder("custom_tracer").startSpan();
        span.setAttribute("input.count", count);

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

        span.setAttribute("output", sum);
        span.end();
        return sum;
    }

    public String readWriteInDatabase(int count) {
        Span span = tracer.spanBuilder("custom_tracer").startSpan();
        span.setAttribute("input.count", count);
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

            span.setAttribute("mockData." + span_count, customerProfileRequest.toString());
            span_count++;

            customerService.saveNewCustomer(customerProfileRequest);
        }

        StringBuilder customerData = new StringBuilder();
        for (int i=1;i<=count;i++) {
            CustomerProfile customerProfile = customerService.fetchCustomerProfile(i);

            span.setAttribute("mockData." + span_count, customerProfile.toString());
            span_count++;

            customerData.append(customerProfile.toString()).append("\n");
        }

        String s = customerData.toString();
        span.setAttribute("output", s);
        span.end();
        return s;
    }

    public String genManyNetworkCall(int count) {

        Span span = tracer.spanBuilder("custom_tracer").startSpan();
        span.setAttribute("input.count", count);

        StringBuilder weatherData = new StringBuilder();
        for (int i=0;i<=count-1;i++) {
            WeatherInfo weatherInfo = weatherService.getWeatherForAddress("Bengaluru");
            weatherData.append(weatherInfo.toString()).append("\n");
        }

        span.end();
        return weatherData.toString();
    }
	
}
