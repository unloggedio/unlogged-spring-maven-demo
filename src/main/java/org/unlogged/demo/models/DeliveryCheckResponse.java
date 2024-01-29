package org.unlogged.demo.models;


import org.unlogged.demo.models.weather.WeatherInfo;

public class DeliveryCheckResponse {
    private CustomerProfile customerProfile;
    private boolean requestWritten;
    private boolean canDeliver;
    private WeatherInfo weatherInfo;

    public DeliveryCheckResponse(CustomerProfile customerProfile, boolean requestWritten, boolean canDeliver, WeatherInfo weatherInfo) {
        this.customerProfile = customerProfile;
        this.requestWritten = requestWritten;
        this.canDeliver = canDeliver;
        this.weatherInfo = weatherInfo;
    }

    public DeliveryCheckResponse() {
    }

    public CustomerProfile getCustomerProfile() {
        return customerProfile;
    }

    public void setCustomerProfile(CustomerProfile customerProfile) {
        this.customerProfile = customerProfile;
    }

    public boolean isRequestWritten() {
        return requestWritten;
    }

    public void setRequestWritten(boolean requestWritten) {
        this.requestWritten = requestWritten;
    }

    public boolean isCanDeliver() {
        return canDeliver;
    }

    public void setCanDeliver(boolean canDeliver) {
        this.canDeliver = canDeliver;
    }

    public WeatherInfo getWeatherInfo() {
        return weatherInfo;
    }

    public void setWeatherInfo(WeatherInfo weatherInfo) {
        this.weatherInfo = weatherInfo;
    }
}
