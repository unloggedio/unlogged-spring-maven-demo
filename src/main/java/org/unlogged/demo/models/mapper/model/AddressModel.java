package org.unlogged.demo.models.mapper.model;

public class AddressModel {
    private String house;
    private String street;
    private String area;
    private String city;
    private String state;
    private String country;
    private String pincode;

    public AddressModel(String house, String street, String area, String city, String state, String country, String pincode) {
        this.house = house;
        this.street = street;
        this.area = area;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "#" + house + ", " + state + ", " + area + ", " + city
                + ", " + state + ", " + country + " - Pin-code : " + pincode;
    }
}
