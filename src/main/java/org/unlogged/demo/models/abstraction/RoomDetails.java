package org.unlogged.demo.models.abstraction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDetails {
    private Long roomId;
    private Long parentPropertyId;
    private String roomName;
    private String roomDescription;
    private RoomType roomType;

    private double pricePerDay;
    private int maxCapacity;
    private int occupiedCapacity;
    private Map<BookDayPriceMap, Double> customPriceMap;
    private List<Amenities> amenitiesList;
}
