package org.unlogged.demo.models.abstraction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDetails {
    private Long locationId;
    private String addressString;
    private String city;
    private String zipCode;
    private String country;
    private String state;

    private double latitude;
    private double longitude;
}
