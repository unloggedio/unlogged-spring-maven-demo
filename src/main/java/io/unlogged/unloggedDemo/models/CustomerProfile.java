package io.unlogged.unloggedDemo.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerProfile {
    private long customerId;
    private String customerName;
    private Date dateOfBirth;
    private String email;
    private String contactNumber;
    private String address;
    private List<String> referralCodes;

    public CustomerProfile(long customerId, String customerName, Date dateOfBirth, String email, String contactNumber, String address, List<String> referralCodes) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.contactNumber = contactNumber;
        this.address = address;
        this.referralCodes = referralCodes;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getReferralCodes() {
        return referralCodes;
    }

    public void setReferralCodes(ArrayList<String> referralCodes) {
        this.referralCodes = referralCodes;
    }

    @Override
    public String toString() {
        return "CustomerProfile{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", email='" + email + '\'' +
                ", contactNumbers=" + contactNumber +
                ", address='" + address + '\'' +
                ", referralCodes=" + referralCodes +
                '}';
    }
}
