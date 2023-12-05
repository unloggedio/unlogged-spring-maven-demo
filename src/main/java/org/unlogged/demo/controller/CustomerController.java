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
    public CustomerProfile getCustomerProfile(@RequestParam long customerID){
        return customerService.fetchCustomerProfile(customerID);
    }

    @RequestMapping("/create")
    @PostMapping
    public CustomerProfile saveCustomerProfile(@RequestParam CustomerProfileRequest saveRequest) {
        CustomerProfile customer = customerService.saveNewCustomer(saveRequest);
        return customer;
    }

    @RequestMapping("/remove")
    public CustomerProfile removeCustomerProfile(@RequestParam long customerID) {
        return customerService.removeCustomer(customerID);
    }

    @RequestMapping("/generateReferral")
    public CustomerProfile generateNeReferralCode(@RequestParam long customerID) {
        return customerService.generateReferralForCustomer(customerID);
    }

    public CustomerScoreCard isCustomerEligibleForLoyaltyProgram(@RequestParam long customerID) {
        return customerService.isCustomerEligibleForPremium(customerID);
    }

    public float gen_sum (float a, float b) {
        float val = a + b;
        return val;
    }

}
