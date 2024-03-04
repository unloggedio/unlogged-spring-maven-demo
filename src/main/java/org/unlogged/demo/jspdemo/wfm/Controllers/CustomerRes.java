package org.unlogged.demo.jspdemo.wfm.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.unlogged.demo.jspdemo.wfm.Models.Entities.CustomerProfile;
import org.unlogged.demo.jspdemo.wfm.Models.Entities.CustomerProfileRequest;
import org.unlogged.demo.jspdemo.wfm.Models.Entities.CustomerScoreCard;
import org.unlogged.demo.jspdemo.wfm.Services.CustomerService;

import java.util.ArrayList;

@RestController
@RequestMapping("/customer/v0")
public class CustomerRes {

    private CustomerService customerService = new CustomerService();

    @RequestMapping("/")
    private CustomerProfile getCustomerProfile(@RequestParam long customerID) {
        CustomerProfile profile =  customerService.fetchCustomerProfile(customerID);
        profile.setContactNumbers(new ArrayList<>());
        profile.setEmail("e.gmail.com");
        profile.getReferralCodes().add("EEEE");
        profile.setAddress("Pripyat");
        profile.setCustomerId(45);
        profile.setDateOfBirth(null);

        return profile;
    }

    @RequestMapping("/create")
    private CustomerProfile saveCustomerProfile(@RequestParam CustomerProfileRequest saveRequest) {
        return customerService.saveNewCustomer(saveRequest);
    }

    @RequestMapping("/remove")
    private CustomerProfile removeCustomerProfile(@RequestParam long customerID) {
        return customerService.removeCustomer(customerID);
    }

    @RequestMapping("/addContact")
    private CustomerProfile addNewContactNumber(@RequestParam long customerID,
                                                @RequestParam String number) {
        return customerService.addNewContact(customerID, number);
    }

    @RequestMapping("/generateReferral")
    private CustomerProfile generateNeReferralCode(@RequestParam long customerID) {
        return customerService.generateReferralForCustomer(customerID);
    }

    private CustomerScoreCard isCustomerEligibleForLoyaltyProgram(@RequestParam long customerID) {
        return customerService.isCustomerEligibleForPremium(customerID);
    }

}
