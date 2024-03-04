package org.unlogged.demo.jspdemo.wfm.Models.Entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerProfile {
    private long customerId;
    private String customerName;
    private Date dateOfBirth;
    private String email;
    private List<String> contactNumbers;
    private String address;
    private List<String> referralCodes;

    public CustomerProfile(long customerId, String customerName, Date dateOfBirth, String email, List<String> contactNumbers, String address, List<String> referralCodes) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.contactNumbers = contactNumbers;
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

    public List<String> getContactNumbers() {
        return contactNumbers;
    }

    public void setContactNumbers(ArrayList<String> contactNumbers) {
        this.contactNumbers = contactNumbers;
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
                ", contactNumbers=" + contactNumbers +
                ", address='" + address + '\'' +
                ", referralCodes=" + referralCodes +
                '}';
    }
}
