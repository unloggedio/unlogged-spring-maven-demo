package org.unlogged.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.unlogged.demo.models.CustomerProfile;
import org.unlogged.demo.models.CustomerProfileRequest;
import org.unlogged.demo.models.CustomerScoreCard;
import org.unlogged.demo.service.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/get")
    private CustomerProfile getCustomerProfile(@RequestParam long customerID) {
        CustomerProfile e = customerService.fetchCustomerProfile(customerID);
        return e;
    }

    @RequestMapping("/create")
    @PostMapping
    private CustomerProfile saveCustomerProfile(@RequestParam CustomerProfileRequest saveRequest) {
        return customerService.saveNewCustomer(saveRequest);
    }

    @RequestMapping("/remove")
    private CustomerProfile removeCustomerProfile(@RequestParam long customerID) {
        return customerService.removeCustomer(customerID);
    }

    @RequestMapping("/generateReferral")
    private CustomerProfile generateNeReferralCode(@RequestParam long customerID) {
        return customerService.generateReferralForCustomer(customerID);
    }

    private CustomerScoreCard isCustomerEligibleForLoyaltyProgram(@RequestParam long customerID) {
        return customerService.isCustomerEligibleForPremium(customerID);
    }

}
