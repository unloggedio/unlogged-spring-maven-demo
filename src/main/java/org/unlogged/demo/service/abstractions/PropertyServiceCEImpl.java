package org.unlogged.demo.service.abstractions;

import org.unlogged.demo.models.abstraction.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PropertyServiceCEImpl implements CrudService<PropertyDetails, Long> {
    @Override
    public PropertyDetails getById(Long id) {
        PropertyDetails propertyDetails = new PropertyDetails();
        propertyDetails.setPropertyId(1L);
        propertyDetails.setPropertyName("Default Property");
        propertyDetails.setDescription("Default location");
        propertyDetails.setLocationDetails(new LocationDetails(
                1L, "Address line, l1, l2", "City1", "ZIP-098", "country1", "State1", 1.0, 2.0
        ));
        Map<BookDayPriceMap, Double> priceMap = new HashMap<>();
        priceMap.put(BookDayPriceMap.WEEKDAY, null);
        priceMap.put(BookDayPriceMap.WEEKEND, 1.18);
        priceMap.put(BookDayPriceMap.HOLIDAY, null);
        propertyDetails.setRoomDetailsList(List.of(
                new RoomDetails(1L, 1L, "Room1", "Default Room1", RoomType.PRIVATE_ROOM,
                        1200.0, 4, 4,
                        priceMap, List.of(Amenities.AC, Amenities.WIFI)),
                new RoomDetails(2L, 1L, "Room2", "Default Room2", RoomType.DORM_ROOM,
                        750.0, 8, 3,
                        priceMap, List.of(Amenities.AC, Amenities.WIFI, Amenities.WASHING_MACHINE))
        ));
        propertyDetails.setOwnerDetails(new OwnerDetails(1L, "Owner1", "Owner1@ownermail.com", "OwnPhone",
                new LocationDetails(
                        2L, "Address line own, l23, l24", "City l12", "ZIP-012", "country 123", "State 44", 123.34, 25.12
                )));
        return propertyDetails;
    }

    @Override
    public List<PropertyDetails> getAll() {
        PropertyDetails propertyDetails = new PropertyDetails();
        propertyDetails.setPropertyId(1L);
        propertyDetails.setPropertyName("Default Property");

        PropertyDetails propertyDetails1 = new PropertyDetails();
        propertyDetails1.setPropertyId(2L);
        propertyDetails1.setPropertyName("Property 2");
        return List.of(propertyDetails, propertyDetails1);
    }

    @Override
    public PropertyDetails insertNew(PropertyDetails propertyDetails) {

        propertyDetails.setPropertyName(propertyDetails.getPropertyName() + "#Added");
        return propertyDetails;
    }

    @Override
    public PropertyDetails updateExisting(PropertyDetails propertyDetails) {

        propertyDetails.setPropertyName(propertyDetails.getPropertyName() + "#Updated");
        return propertyDetails;
    }

    @Override
    public PropertyDetails deleteById(Long id) {
        PropertyDetails details = getById(0L);
        details.setPropertyName(details.getPropertyName() + "#Deleted");
        return details;
    }
}
