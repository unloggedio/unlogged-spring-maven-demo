package org.unlogged.demo.models.weather;

import lombok.Data;

@Data
public class WeatherInfo {
    public Location location;
    public Current current;
}

