package org.unlogged.demo.models;


import lombok.Data;
import org.unlogged.demo.models.weather.WeatherInfo;
@Data
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
}
