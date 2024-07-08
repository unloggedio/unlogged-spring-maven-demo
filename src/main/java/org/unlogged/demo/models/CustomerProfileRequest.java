package org.unlogged.demo.models;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;

import static org.unlogged.demo.OtelConfig.makeSpan;
import static org.unlogged.demo.OtelConfig.registerMethod;

import java.util.List;

public class CustomerProfileRequest {

    private static final Tracer tracer = GlobalOpenTelemetry.getTracer("unlogged-spring-maven-demo");

    private String customerName;
    private String dateOfBirth;
    private String email;
    private String primaryNumber;
    private String address;
    private List<String> codes;

        public CustomerProfileRequest(String customerName, String dateOfBirth, String email, String primaryNumber, String address) {
        Span span = tracer.spanBuilder("custom_tracer.22").startSpan();
        makeSpan(span, "input.customerName", customerName);
        makeSpan(span, "input.dateOfBirth", dateOfBirth);
        makeSpan(span, "input.email", email);
        makeSpan(span, "input.primaryNumber", primaryNumber);
        makeSpan(span, "input.address", address);

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

    static {
        Span span = tracer.spanBuilder("method_registration").startSpan();
        registerMethod(span, 22, "org.unlogged.demo.models.CustomerProfileRequest", "<init>", "java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String", "V", false, true, true, 1, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V");
        span.end();
    }
}
