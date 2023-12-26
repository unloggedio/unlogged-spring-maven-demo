package org.unlogged.demo.models;

import lombok.Data;

import java.util.List;

@Data
public class CustomerProfileRequest {
    private String customerName;
    private String dateOfBirth;
    private String email;
    private String primaryNumber;
    private String address;
    private List<String> codes;
}
