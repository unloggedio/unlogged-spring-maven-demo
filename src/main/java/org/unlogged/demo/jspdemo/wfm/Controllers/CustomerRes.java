package org.unlogged.demo.jspdemo.wfm.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.unlogged.demo.jspdemo.wfm.Models.Entities.CustomerProfile;
import org.unlogged.demo.jspdemo.wfm.Models.Entities.CustomerProfileRequest;
import org.unlogged.demo.jspdemo.wfm.Models.Entities.CustomerScoreCard;
import org.unlogged.demo.jspdemo.wfm.Services.CustomerService;
import org.unlogged.demo.mapper.CustomerDTO;
import org.unlogged.demo.mapper.CustomerProfileDTOAssembler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer/v0")
public class CustomerRes {

    private CustomerService customerService = new CustomerService();
    @Autowired
    CustomerProfileDTOAssembler customerProfileDTOAssembler;

    @Autowired
    ModelMapper modelMapper;

    @RequestMapping("/")
    private CustomerProfile getCustomerProfile(@RequestParam long customerID) {
        CustomerProfile profile = customerService.fetchCustomerProfile(customerID);
        profile.setContactNumbers(new ArrayList<>());
        profile.setEmail("e.gmail.com");
        profile.getReferralCodes().add("EEEE");
        profile.setAddress("Pripyat");
        profile.setCustomerId(45);
        profile.setDateOfBirth(null);

        return profile;
    }

    @RequestMapping("/dto")
    public ResponseEntity<EntityModel<CustomerDTO>> getCustomerDto(@RequestParam long id) {
        return new ResponseEntity<>(customerProfileDTOAssembler.toModel(getCustomerDtoForId(id)), HttpStatus.OK);
    }

    private CustomerDTO getCustomerDtoForId(long id) {
        CustomerProfile profile = new CustomerProfile(1, "a", new Date(), "a", new ArrayList<>(), "a", new ArrayList<>());

//        return modelMapper.map(customerService.fetchCustomerProfile(id), CustomerDTO.class);
        return modelMapper.map(profile, CustomerDTO.class);
    }

    public ResponseEntity<List<CustomerProfile>> getAllCustomers() {
        return new ResponseEntity<List<CustomerProfile>>(customerService.getAllCustomers(), HttpStatusCode.valueOf(200));
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
