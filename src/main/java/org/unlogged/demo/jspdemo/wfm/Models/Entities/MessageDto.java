package org.unlogged.demo.jspdemo.wfm.Models.Entities;

public class MessageDto {
    private int gcd;
    private String weather;

    public int getGcd() {
        return gcd;
    }

    public void setGcd(int gcd) {
        this.gcd = gcd;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public MessageDto() {
    }

    public MessageDto(int gcd, String weather) {
        this.gcd = gcd;
        this.weather = weather;
    }
}
