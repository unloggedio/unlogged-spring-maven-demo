package org.unlogged.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unlogged.demo.dao.CustomerProfileRepo;
import org.unlogged.demo.jspdemo.wfm.Models.Entities.User;
import org.unlogged.demo.models.CustomerProfile;
import org.unlogged.demo.security.repository.UserRepository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/var")
public class VarOpsController {

    @Autowired
    private CustomerProfileRepo customerProfileRepo;

    @RequestMapping("/primitives")
    public List<Object> primitivesWrapped() {
        var integerValue = 1;
        var longValue = 1L;
        var floatValue = 1.0f;
        var doubleValue = 1.0d;
        var charValue = 'a';
        var stringValue = "String";
        var listOfString = List.of("v1", "v2", "v3");
        return Arrays.asList(integerValue, longValue, floatValue, doubleValue, charValue, stringValue, listOfString);
    }

    @RequestMapping("/user")
    public User getAUser() {
        var user = new User();
        user.setUser_id(199);
        user.setEmail("user199@gmail.com");
        user.setPassword("userpass199");
        user.setUsername("user199");
        return user;
    }

    @RequestMapping("/mapUsers")
    public Map<String, List<User>> varListAndMap() {
        var listOfUsers = List.of(
                new User(11, "UserA", "a", "userA@gmail.com"),
                new User(23, "UserB", "b", "userB@gmail.com"),
                new User(14, "UserC", "c", "userC@gmail.com"),
                new User(59, "UserD", "d", "userD@gmail.com"),
                new User(64, "UserE", "e", "userE@gmail.com"),
                new User(80, "UserF", "f", "userF@gmail.com"),
                new User(24, "UserG", "g", "userG@gmail.com")
        );
        var mapOfUsers = new HashMap<String, List<User>>();
        mapOfUsers.put("Odd", listOfUsers.stream().filter(user -> user.getUser_id() % 2 != 0).toList());
        mapOfUsers.put("Even", listOfUsers.stream().filter(user -> user.getUser_id() % 2 == 0).toList());

        return mapOfUsers;
    }

    @RequestMapping("/responseEntityWrapped")
    public ResponseEntity<Map<String, List<User>>> getAsResponseEntity() {
        var responseBody = varListAndMap();
        var response = new ResponseEntity<Map<String, List<User>>>(responseBody, HttpStatusCode.valueOf(200));
        return response;
    }

    @RequestMapping("/dbPojo")
    public ResponseEntity<List<CustomerProfile>> getCustomers() {
        var customers = customerProfileRepo.findAll();
        if (customers.isEmpty()) {
            customerProfileRepo.save(new CustomerProfile(1, "c1", "dob1", "email1", "001", "address", List.of("1", "2")));
            customerProfileRepo.save(new CustomerProfile(2, "c2", "dob2", "email2", "002", "address", List.of("1", "2")));
            customers = customerProfileRepo.findAll();
        }
        var responseEntity = ResponseEntity.ok(customers);
        return responseEntity;
    }
}
