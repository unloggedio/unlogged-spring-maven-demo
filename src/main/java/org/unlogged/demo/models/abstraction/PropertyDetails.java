package org.unlogged.demo.models.abstraction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDetails {
    private Long propertyId;
    private String propertyName;
    private String description;
    private OwnerDetails ownerDetails;
    private LocationDetails locationDetails;
    private List<RoomDetails> roomDetailsList;
}
