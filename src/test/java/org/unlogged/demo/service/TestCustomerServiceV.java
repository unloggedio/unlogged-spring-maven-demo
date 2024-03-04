package org.unlogged.demo.service;

import static io.unlogged.UnloggedTestUtils.*;
import static org.mockito.ArgumentMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.Exception;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.unlogged.demo.dao.CustomerProfileRepo;
import org.unlogged.demo.models.CustomerScoreCard;
import org.unlogged.demo.repository.CustomerProfileRepository;

public final class TestCustomerServiceV {
  private CustomerService customerService;

  private CustomerProfileRepository customerProfileRepository;

  private CustomerProfileRepo repo;

  private ObjectMapper objectMapper = new ObjectMapper();

  @Before
  public void setup() throws Exception {
    customerProfileRepository = Mockito.mock(CustomerProfileRepository.class);
    repo = Mockito.mock(CustomerProfileRepo.class);
    customerService = new CustomerService();
    injectField(customerService, "customerProfileRepository", customerProfileRepository);
    injectField(customerService, "repo", repo);
  }

  @Test
  public void testMethodGetCustomerScoreCard() throws Exception {
    // 
    CustomerScoreCard fetchCustomerScoreCardResult = objectMapper.readValue("{\"customerProfile\": {\"customerid\": \"0\", \"customername\": \"string\", \"dateofbirth\": \"string\", \"email\": \"string\", \"contactnumber\": \"string\", \"address\": \"string\", \"referralcodes\": [\"string\"]}, \"score\": \"0\", \"isEligible\": true, \"valTime\": 1709536099204, \"valDate\": 1709536099206}", CustomerScoreCard.class);
    Mockito.when(customerProfileRepository.fetchCustomerScoreCard(eq(-898573460736172445L))).thenReturn(fetchCustomerScoreCardResult);
    // 
    CustomerScoreCard customerScoreCard = customerService.getCustomerScoreCard(0);
    CustomerScoreCard customerScoreCardExpected = null;
    Assert.assertEquals(customerScoreCardExpected, customerScoreCard);
  }
}
