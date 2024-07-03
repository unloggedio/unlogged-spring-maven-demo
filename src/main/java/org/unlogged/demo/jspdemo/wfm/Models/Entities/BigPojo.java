package org.unlogged.demo.jspdemo.wfm.Models.Entities;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.unlogged.demo.OtelConfig.makeSpan;

public class BigPojo {

    private final Tracer tracer = GlobalOpenTelemetry.getTracer("unlogged-spring-maven-demo");

    public BigPojo() {

    }

    public BigPojo(int id) {
        Span span = tracer.spanBuilder("custom_tracer").startSpan();
        makeSpan(span, "input.id", id);

        Random rand = new Random();
        makeSpan(span, "mockData.1", rand);

        this.id = id;

        int rand_2 = rand.nextInt(1000);
        this.make_id = id + rand_2;
        makeSpan(span, "mockData.2", rand_2);

        int rand_3 = rand.nextInt(1000);
        this.model_id = id + rand_3;
        makeSpan(span, "mockData.3", rand_3);

        int rand_4 = rand.nextInt(1000);
        this.pl_id = id + rand_4;
        makeSpan(span, "mockData.4", rand_4);


        String rand_5 = genRandomString(rand, 100);
        this.make_name = rand_5;
        makeSpan(span, "mockData.5", rand_5);

        String rand_6 = genRandomString(rand, 100);
        this.model_name = rand_6;
        makeSpan(span, "mockData.6", rand_6);

        String rand_7 = genRandomString(rand, 100);
        this.pl_name = rand_7;
        makeSpan(span, "mockData.7", rand_7);


        this.year_of_make = "2000";

        String rand_8 = genRandomString(rand, 10000);
        this.description_text = rand_8;
        makeSpan(span, "mockData.8", rand_8);

        String rand_9 = genRandomString(rand, 10000);
        this.pl_Description = rand_9;
        makeSpan(span, "mockData.9", rand_9);

        String rand_10 = genRandomString(rand, 10000);
        this.data_holder_1 = rand_10;
        makeSpan(span, "mockData.10", rand_10);

        String rand_11 = genRandomString(rand, 10000);
        this.data_holder_2 = rand_11;
        makeSpan(span, "mockData.11", rand_11);

        String rand_12 = genRandomString(rand, 10000);
        this.data_holder_3 = rand_12;
        makeSpan(span, "mockData.12", rand_12);

        int rand_13 = rand.nextInt(100);
        int count = rand_13;
        makeSpan(span, "mockData.13", rand_13);

        this.program_ids = new ArrayList<>();
        for (int i=0;i<=count-1;i++) {
            int val = rand.nextInt(1000);
            this.program_ids.add(val);
            makeSpan(span, "mockData." + 14 + count, val);
        }

        span.end();
    }

    private int id;
    private int make_id;
    private int model_id;
    private String make_name;
    private String model_name;
    private int pl_id;
    private String pl_name;
    private String year_of_make;
    private String description_text;
    private String pl_Description;
    private List<Integer> program_ids;
    private String data_holder_1;
    private String data_holder_2;
    private String data_holder_3;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMake_id() {
        return make_id;
    }

    public void setMake_id(int make_id) {
        this.make_id = make_id;
    }

    public int getModel_id() {
        return model_id;
    }

    public void setModel_id(int model_id) {
        this.model_id = model_id;
    }

    public String getMake_name() {
        return make_name;
    }

    public void setMake_name(String make_name) {
        this.make_name = make_name;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public int getPl_id() {
        return pl_id;
    }

    public void setPl_id(int pl_id) {
        this.pl_id = pl_id;
    }

    public String getPl_name() {
        return pl_name;
    }

    public void setPl_name(String pl_name) {
        this.pl_name = pl_name;
    }

    public String getYear_of_make() {
        return year_of_make;
    }

    public void setYear_of_make(String year_of_make) {
        this.year_of_make = year_of_make;
    }

    public String getDescription_text() {
        return description_text;
    }

    public void setDescription_text(String description_text) {
        this.description_text = description_text;
    }

    public String getPl_Description() {
        return pl_Description;
    }

    public void setPl_Description(String pl_Description) {
        this.pl_Description = pl_Description;
    }

    public List<Integer> getProgram_ids() {
        return program_ids;
    }

    public void setProgram_ids(List<Integer> program_ids) {
        this.program_ids = program_ids;
    }

    public String getData_holder_1() {
        return data_holder_1;
    }

    public void setData_holder_1(String data_holder_1) {
        this.data_holder_1 = data_holder_1;
    }

    public String getData_holder_2() {
        return data_holder_2;
    }

    public void setData_holder_2(String data_holder_2) {
        this.data_holder_2 = data_holder_2;
    }

    public String getData_holder_3() {
        return data_holder_3;
    }

    public void setData_holder_3(String data_holder_3) {
        this.data_holder_3 = data_holder_3;
    }

    private String genRandomString(Random rand, int length) {
        Span span = tracer.spanBuilder("custom_tracer").startSpan();
        makeSpan(span, "input.rand", rand);
        makeSpan(span, "input.length", length);

        byte[] arr = new byte[length];
        rand.nextBytes(arr);
        makeSpan(span, "mockData.1", arr);

        String randomString = new String(arr, StandardCharsets.UTF_8);
        makeSpan(span, "output", randomString);
        span.end();
        return randomString;
    }

    public String toString() {
        Span span = tracer.spanBuilder("custom_tracer").startSpan();

        StringBuilder s = new StringBuilder();
        s.append("id = ").append(id).append(" ")
                .append("make_id = ").append(make_id).append(" ")
                .append("model_id = ").append(model_id).append(" ")
                .append("make_name = ").append(make_name).append(" ")
                .append("model_name = ").append(model_name).append(" ")
                .append("pl_id = ").append(pl_id).append(" ")
                .append("pl_name = ").append(pl_name).append(" ")
                .append("year_of_make = ").append(year_of_make).append(" ")
                .append("description_text = ").append(description_text).append(" ")
                .append("pl_Description = ").append(pl_Description).append(" ")
                .append("program_ids = ").append(program_ids).append(" ")
                .append("data_holder_1 = ").append(data_holder_1).append(" ")
                .append("data_holder_2 = ").append(data_holder_2).append(" ")
                .append("data_holder_3 = ").append(data_holder_3).append(" ");

        String string = s.toString();
        makeSpan(span, "output", string);
        span.end();
        return string;
    }
}