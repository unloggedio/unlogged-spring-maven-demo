package org.unlogged.demo.models;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerProfileRequest {

    private final Tracer tracer = GlobalOpenTelemetry.getTracer("unlogged-spring-maven-demo");

    private String customerName;
    private String dateOfBirth;
    private String email;
    private String primaryNumber;
    private String address;
    private List<String> codes;

    public CustomerProfileRequest(String customerName, String dateOfBirth, String email, String primaryNumber, String address) {
        Span span = tracer.spanBuilder("custom_tracer").startSpan();
        span.setAttribute("input.customerName", customerName);
        span.setAttribute("input.dataOfBirth", dateOfBirth);
        span.setAttribute("input.email", email);
        span.setAttribute("input.primaryNumber", primaryNumber);
        span.setAttribute("input.address", address);

        this.customerName = customerName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.primaryNumber = primaryNumber;
        this.address = address;

        span.end();
    }

    public CustomerProfileRequest() {
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrimaryNumber() {
        return primaryNumber;
    }

    public void setPrimaryNumber(String primaryNumber) {
        this.primaryNumber = primaryNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getCodes() {
        return codes;
    }

    public void setCodes(List<String> codes) {
        this.codes = codes;
    }
}
