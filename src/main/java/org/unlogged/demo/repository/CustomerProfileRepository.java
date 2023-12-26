package org.unlogged.demo.repository;

import org.springframework.stereotype.Service;
import org.unlogged.demo.models.CustomerProfile;
import org.unlogged.demo.models.CustomerProfileRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

@Service
public class CustomerProfileRepository {

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
        profileTreeMap.put(profile.getCustomerid(), profile);
        return profile;
    }

    public CustomerProfile removeCustomer(long customerID) {
        CustomerProfile profile = profileTreeMap.get(customerID);
        profileTreeMap.remove(customerID);
        return profile;
    }

    //retuns mock values for customer profiles
    public List<CustomerProfile> getAsianCustomers() {
        List<CustomerProfile> customerProfiles = new ArrayList<>();

        List<String> referralCodes = new ArrayList<>();
        referralCodes.add("VtYxq8m0Op0M");
        referralCodes.add("LyJMqECNr3vn");
        referralCodes.add("650wm3aKyOwx");
        referralCodes.add("8LJILw5hfuPH");
        referralCodes.add("jMGOEhv8hOMU");

        CustomerProfile customerProfile = new CustomerProfile(3,
                "aman", "20-2-1996", "aman876@gmail.com",
                "9527861967", "Gujarat, India", referralCodes);
        customerProfiles.add(customerProfile);

        referralCodes = new ArrayList<>();
        referralCodes.add("VtYxq8m0Op0M");
        referralCodes.add("LyJMqECNr3vn");
        referralCodes.add("650wm3aKyOwx");
        referralCodes.add("8LJILw5hfuPH");
        referralCodes.add("jMGOEhv8hOMU");
        referralCodes.add("7Ffb8QoG4gLG");

        customerProfile = new CustomerProfile(4,
                "toro", "14-4-1993", "toro.nani@gmail.com",
                "5670926480", "Kyoto, Japan", referralCodes);
        customerProfiles.add(customerProfile);

        referralCodes = new ArrayList<>();
        referralCodes.add("VtYxq8m0Op0M");
        referralCodes.add("LyJMqECNr3vn");
        referralCodes.add("650wm3aKyOwx");
        referralCodes.add("8LJILw5hfuPH");
        referralCodes.add("jMGOEhv8hOMU");
        referralCodes.add("7Ffb8QoG4gLG");

        customerProfile = new CustomerProfile(5,
                "ashok", "14-4-1993", "ashok.shah@gmail.com",
                "5670926480", "Kathmandu, Nepal", referralCodes);
        customerProfiles.add(customerProfile);

        return customerProfiles;
    }

    public List<CustomerProfile> getInternationalCustomers() {
        List<CustomerProfile> customerProfiles = new ArrayList<>();
        String address = "304 Alanis Parkway, Boylemouth, Virginia";
        List<String> referralCodes = new ArrayList<>();
        referralCodes.add("VtYxq8m0Op0M");
        referralCodes.add("LyJMqECNr3vn");
        referralCodes.add("650wm3aKyOwx");
        referralCodes.add("8LJILw5hfuPH");
        referralCodes.add("jMGOEhv8hOMU");
        referralCodes.add("7Ffb8QoG4gLG");

        CustomerProfile customerProfile = new CustomerProfile(1,
                "John doe", "1998-9-25", "john.doe@gmail.com",
                "9825672456", address, referralCodes);
        customerProfiles.add(customerProfile);

        referralCodes = new ArrayList<>();
        referralCodes.add("sdfjhsdflsnf");
        referralCodes.add("LyJMqsldfjns");
        referralCodes.add("sdfkjbsjhfgs");

        customerProfile = new CustomerProfile(2,
                "DJ", "1992-12-2", "djm@gmail.com",
                "4678251601", "Hella, Iceland", referralCodes);
        return customerProfiles;
    }
}
