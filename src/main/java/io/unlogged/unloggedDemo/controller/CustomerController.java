package io.unlogged.unloggedDemo.controller;

import io.unlogged.unloggedDemo.models.CustomerProfile;
import io.unlogged.unloggedDemo.models.CustomerProfileRequest;
import io.unlogged.unloggedDemo.models.CustomerScoreCard;
import io.unlogged.unloggedDemo.service.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService = new CustomerService();

    @RequestMapping("/get")
    private CustomerProfile getCustomerProfile(@RequestParam long customerID) {
        return customerService.fetchCustomerProfile(customerID);
    }

    @RequestMapping("/create")
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
