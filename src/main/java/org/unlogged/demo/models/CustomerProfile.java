package org.unlogged.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
@Entity
@Table(name = "customerprofile")
public class CustomerProfile {
    @Id
    private long customerid;
    private String customername;
    private String dateofbirth;
    private String email;
    private String contactnumber;
    private String address;
    private List<String> referralcodes;

    public CustomerProfile() {
    }

    public CustomerProfile(long customerid, String customername, String dateofbirth, String email, String contactnumber, String address, List<String> referralcodes) {
        this.customerid = customerid;
        this.customername = customername;
        this.dateofbirth = dateofbirth;
        this.email = email;
        this.contactnumber = contactnumber;
        this.address = address;
        this.referralcodes = referralcodes;
    }
}
