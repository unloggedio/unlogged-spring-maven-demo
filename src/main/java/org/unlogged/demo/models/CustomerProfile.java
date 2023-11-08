package org.unlogged.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;
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

    public long getCustomerid() {
        return customerid;
    }

    public void setCustomerid(long customerid) {
        this.customerid = customerid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(String contactnumber) {
        contactnumber = contactnumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getReferralcodes() {
        return referralcodes;
    }

    public void setReferralcodes(ArrayList<String> referralcodes) {
        this.referralcodes = referralcodes;
    }

    @Override
    public String toString() {
        return "CustomerProfile{" +
                "customerId=" + customerid +
                ", customerName='" + customername + '\'' +
                ", dateOfBirth=" + dateofbirth +
                ", email='" + email + '\'' +
                ", contactNumbers=" + contactnumber +
                ", address='" + address + '\'' +
                ", referralCodes=" + referralcodes +
                '}';
    }
}
