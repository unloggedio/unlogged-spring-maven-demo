package org.unlogged.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.Exception;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.unlogged.demo.models.CustomerProfile;
import org.unlogged.demo.models.CustomerProfileRequest;
import org.unlogged.demo.service.CustomerService;
import static io.unlogged.UnloggedTestUtils.*;
import static org.mockito.ArgumentMatchers.*;

public final class TestCustomerControllerV {

    private CustomerController customerController;

    private CustomerService customerService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setup() throws Exception {
        customerService = Mockito.mock(CustomerService.class);
        customerController = new CustomerController();
        injectField(customerController, "customerService", customerService);
    }

    @Test
    public void testMethodSaveCustomerProfile() throws Exception {
        //
        CustomerProfile saveNewCustomerResult = objectMapper.readValue("{\"customerid\":10,\"customername\":\"string\",\"dateofbirth\":\"string\",\"email\":\"string\",\"contactnumber\":\"string\",\"address\":\"string\",\"referralcodes\":[\"aevwtbvylx\",\"ufyfhdqhjc\",\"kowppnxalq\",\"pafllftzyw\",\"xqzzmrgxfy\"]}", CustomerProfile.class);
        // org.unlogged.demo.models.CustomerProfile saveNewCustomerResult = customerService.saveNewCustomer(1 arguments);
        Mockito.when(customerService.saveNewCustomer(any(CustomerProfileRequest.class))).thenReturn(saveNewCustomerResult);
        //
        // Test candidate method [saveCustomerProfile] [940,2] - took 79ms
        CustomerProfileRequest saveRequest = objectMapper.readValue("{\"customerName\":\"string\",\"dateOfBirth\":\"string\",\"email\":\"string\",\"primaryNumber\":\"string\",\"address\":\"string\",\"codes\":[\"string\"]}", CustomerProfileRequest.class);
        CustomerProfile customerProfile = customerController.saveCustomerProfile(saveRequest);
        CustomerProfile customerProfileExpected = objectMapper.readValue("{\"customerid\":10,\"customername\":\"string\",\"dateofbirth\":\"string\",\"email\":\"string\",\"contactnumber\":\"string\",\"address\":\"string\",\"referralcodes\":[\"aevwtbvylx\",\"ufyfhdqhjc\",\"kowppnxalq\",\"pafllftzyw\",\"xqzzmrgxfy\"]}", CustomerProfile.class);
        Assert.assertEquals(customerProfileExpected.toString(), customerProfile.toString());
    }

    @Test
    public void testMethodSaveCustomerProfile1() throws Exception {
        //
        CustomerProfile saveNewCustomerResult = objectMapper.readValue("{\"customerid\":10,\"customername\":\"string\",\"dateofbirth\":\"string\",\"email\":\"string\",\"contactnumber\":\"string\",\"address\":\"string\",\"referralcodes\":[\"rubebeylqc\",\"kauvumbuel\",\"lqbakvhwoo\",\"jgpeogkqye\",\"momjnadjux\"]}", CustomerProfile.class);
        // org.unlogged.demo.models.CustomerProfile saveNewCustomerResult = customerService.saveNewCustomer(1 arguments);
        Mockito.when(customerService.saveNewCustomer(any(CustomerProfileRequest.class))).thenReturn(saveNewCustomerResult);
        //
        // Test candidate method [saveCustomerProfile] [2179,2] - took 11ms
        CustomerProfileRequest saveRequest = objectMapper.readValue("{\"customerName\":\"string\",\"dateOfBirth\":\"string\",\"email\":\"string\",\"primaryNumber\":\"string\",\"address\":\"string\",\"codes\":[\"string\"]}", CustomerProfileRequest.class);
        CustomerProfile customerProfile = customerController.saveCustomerProfile(saveRequest);
        CustomerProfile customerProfileExpected = objectMapper.readValue("{\"customerid\":10,\"customername\":\"string\",\"dateofbirth\":\"string\",\"email\":\"string\",\"contactnumber\":\"string\",\"address\":\"string\",\"referralcodes\":[\"rubebeylqc\",\"kauvumbuel\",\"lqbakvhwoo\",\"jgpeogkqye\",\"momjnadjux\"]}", CustomerProfile.class);
        Assert.assertEquals(customerProfileExpected.toString(), customerProfile.toString());
    }
}
