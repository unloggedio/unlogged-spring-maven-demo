package org.unlogged.demo.jspdemo.wfm.Models.Entities;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BigPojo {

    public BigPojo() {

    }

    public BigPojo(int id) {
        Random rand = new Random();
        this.id = id;
        this.make_id = id + rand.nextInt(1000);
        this.model_id = id + rand.nextInt(1000);
        this.pl_id = id + rand.nextInt(1000);

        this.make_name = genRandomString(rand, 100);
        this.model_name = genRandomString(rand, 100);
        this.pl_name = genRandomString(rand, 100);
        this.year_of_make = "2000";
        this.description_text = genRandomString(rand, 10000);
        this.pl_Description = genRandomString(rand, 10000);

        this.data_holder_1 = genRandomString(rand, 10000);
        this.data_holder_2 = genRandomString(rand, 10000);
        this.data_holder_3 = genRandomString(rand, 10000);

        int count = rand.nextInt(100);
        this.program_ids = new ArrayList<>();
        for (int i=0;i<=count-1;i++) {
            this.program_ids.add(rand.nextInt(1000));
        }
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
        byte[] arr = new byte[length];
        rand.nextBytes(arr);
        String randomString = new String(arr, StandardCharsets.UTF_8);
        return randomString;
    }

    public String toString() {
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

        return s.toString();
    }
}
