package io.unlogged.unloggedDemo.storage;

import io.unlogged.unloggedDemo.models.CustomerProfile;
import io.unlogged.unloggedDemo.models.CustomerProfileRequest;

import java.util.TreeMap;

public class CustomerProfileStore {

    private final TreeMap<Long, CustomerProfile> profileTreeMap = new TreeMap<>();
    int c = 1;

    public CustomerProfile fetchCustomerProfile(long customerID) {
        return this.profileTreeMap.get(customerID);
    }

    public CustomerProfile save(CustomerProfileRequest saveRequest) {
        CustomerProfile profile = new CustomerProfile(c++, saveRequest.getCustomerName(),
                saveRequest.getDateOfBirth(), saveRequest.getEmail(), saveRequest.getPrimaryNumber(), saveRequest.getAddress(), saveRequest.getCodes());
        return save(profile);
    }

    public CustomerProfile save(CustomerProfile profile) {
        profileTreeMap.put(profile.getCustomerId(), profile);
        return profile;
    }

    public CustomerProfile removeCustomer(long customerID) {
        CustomerProfile profile = profileTreeMap.get(customerID);
        profileTreeMap.remove(customerID);
        return profile;
    }
}
