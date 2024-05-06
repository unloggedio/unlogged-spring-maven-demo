package org.unlogged.demo.controller;

import static io.unlogged.UnloggedTestUtils.*;
import static org.mockito.ArgumentMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.Exception;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.unlogged.demo.models.CustomerProfile;
import org.unlogged.demo.service.CustomerService;

public final class TestCustomerControllerV {
  private CustomerController customerController;

  private CustomerService customerService;

  private ObjectMapper objectMapper = new ObjectMapper();

  @BeforeEach
  public void setup() throws Exception {
    customerService = Mockito.mock(CustomerService.class);
    customerController = new CustomerController();
    injectField(customerController, "customerService", customerService);
  }

  @Test
  public void testGetDummyProfile() throws Exception {
    // 
    CustomerProfile backProfile = objectMapper.readValue("{\"customerid\":0,\"customername\":\"string\",\"dateofbirth\":\"string\",\"email\":\"string\",\"contactnumber\":null,\"address\":\"string\",\"referralcodes\":[\"string\"],\"createdDate\":\"May 6, 2024 18:06:13 pm\",\"updatedDate\":\"May 6, 2024 18:06:13 pm\"}", CustomerProfile.class);
    Mockito.when(customerService.getBackProfile(any(CustomerProfile.class))).thenReturn(backProfile);
    // 
    // Test candidate method [getDummyProfile] [1300,15] - took 11ms
    backProfile = customerController.getDummyProfile(backProfile);
    CustomerProfile backProfileExpected = objectMapper.readValue("{\"customerid\":0,\"customername\":\"string\",\"dateofbirth\":\"string\",\"email\":\"string\",\"contactnumber\":null,\"address\":\"string\",\"referralcodes\":[\"string\"],\"createdDate\":\"May 6, 2024 18:06:13 pm\",\"updatedDate\":\"May 6, 2024 18:06:13 pm\"}", CustomerProfile.class);
    Assertions.assertEquals(backProfileExpected, backProfile);
  }
}
