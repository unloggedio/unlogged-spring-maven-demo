package org.unlogged.demo.jspdemo.wfm.Models.Entities;

public class Address {
    private String address;
    private String State;
    private String Country;

    public Address(String address, String state, String country) {
        this.address = address;
        State = state;
        Country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }
}
