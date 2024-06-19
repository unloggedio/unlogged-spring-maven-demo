package org.unlogged.demo.models.abstraction;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OwnerDetails {
    private Long ownerId;
    private String name;
    private String email;
    private String phone;
    private LocationDetails officeLocationDetails;
}
