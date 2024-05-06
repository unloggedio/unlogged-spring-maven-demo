package org.unlogged.demo.jspdemo.wfm.Dao;


import org.unlogged.demo.jspdemo.wfm.Models.Entities.CustomerProfile;
import org.unlogged.demo.jspdemo.wfm.Models.Entities.CustomerProfileRequest;

import java.util.Arrays;
import java.util.TreeMap;

public class CustomerProfileDao {

    TreeMap<Long, CustomerProfile> profileTreeMap = new TreeMap<>();
    int c = 1;

    public CustomerProfileDao() {
    }

    public CustomerProfile fetchCustomerProfile(long customerID) {
        return this.profileTreeMap.get(customerID);
    }

    public CustomerProfile save(CustomerProfileRequest saveRequest) {
        CustomerProfile profile = new CustomerProfile(c++, saveRequest.getCustomerName(),
                saveRequest.getDateOfBirth(), saveRequest.getEmail(), Arrays.asList(saveRequest.getPrimaryNumber()), saveRequest.getAddress(), saveRequest.getCodes());
        return save(profile);
    }

    public CustomerProfile save(CustomerProfile profile) {
        this.profileTreeMap.put(profile.getCustomerId(), profile);
        return profile;
    }

    public CustomerProfile removeCustomer(long customerID) {
        CustomerProfile profile = profileTreeMap.get(customerID);
        profileTreeMap.remove(customerID);
        return profile;
    }
}
