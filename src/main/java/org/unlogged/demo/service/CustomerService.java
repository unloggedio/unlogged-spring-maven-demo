package org.unlogged.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unlogged.demo.constants.ScoreConstants;
import org.unlogged.demo.dao.CustomerProfileRepo;
import org.unlogged.demo.models.CustomerProfile;
import org.unlogged.demo.models.CustomerProfileRequest;
import org.unlogged.demo.models.CustomerScoreCard;
import org.unlogged.demo.models.CustomerScoreCardMap;
import org.unlogged.demo.repository.CustomerProfileRepository;
import org.unlogged.demo.utils.ScoreUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.unlogged.demo.utils.ReferralUtils.generateReferralCode;

@Service
public class CustomerService {
    @Autowired
    private CustomerProfileRepository customerProfileRepository;

    @Autowired
    private CustomerProfileRepo repo;

    public CustomerProfile fetchCustomerProfile(long id) {
        CustomerProfile profile = customerProfileRepository.fetchCustomerProfile(id);
        return profile;
    }

    public CustomerScoreCard getCustomerScoreCard(long customerId) {
        CustomerScoreCard customerScoreCard = customerProfileRepository.fetchCustomerScoreCard(customerId);
        return customerScoreCard;
    }

    public CustomerProfile saveNewCustomer(CustomerProfileRequest saveRequest) {
        return customerProfileRepository.save(saveRequest);
    }

    public CustomerProfile removeCustomer(long customerID) {
        return customerProfileRepository.removeCustomer(customerID);
    }

    private List<String> generateReferralCodes() {
        int codeCount = 5;
        List<String> codes = new ArrayList<>();
        for (int i = 0; i < codeCount; i++) {
            codes.add(generateReferralCode());
        }
        return codes;
    }

    public CustomerScoreCard isCustomerEligibleForPremium(long customerID) {
        CustomerProfile profile = customerProfileRepository.fetchCustomerProfile(customerID);
        int score = 0, bonus = 0;
        boolean isEligible = false;
        if (profile.getAddress().contains("Ohio") ||
                profile.getAddress().contains("Virginia") ||
                profile.getAddress().contains("Texas")) {
            bonus = 2;
        } else {
            bonus = 1;
        }
        int code = 0;
        if (profile.getContactnumber() != null) {
            code += 3;
        }
        if (profile.getAddress() != null) {
            code += 2;
        }
        if (profile.getCustomername() != null) {
            code += 1;
        }
        score += code * (bonus + ScoreConstants.SCORE_PER_REFERRAL);
        if (score >= ScoreConstants.PREMIUM_CUT_OFF) {
            isEligible = true;
        }
        return new CustomerScoreCard(profile, score, isEligible);
    }

    public List<CustomerProfile> filterEligbleCustomers(List<CustomerProfile> customers, boolean asiaFlow) {
        List<CustomerProfile> eligibleCustomers = new ArrayList<>();
        customers = customerProfileRepository.getAsianCustomers();
        if (asiaFlow) {
            for (CustomerProfile customer : customers) {
                int bonus = 0;
                int score = 0;
                int code = 0;
                if (customer.getContactnumber() != null) {
                    code += 3;
                }
                if (customer.getAddress() != null) {
                    code += 2;
                }
                if (customer.getCustomername() != null) {
                    code += 1;
                }
                switch (code) {
                    case 0:
                        bonus = 0;
                        break;
                    case 5:
                        if (customer.getAddress().contains("India")) {
                            bonus = 5;
                        }
                        if (customer.getAddress().contains("Nepal")) {
                            bonus = 5;
                        }
                        if (customer.getAddress().contains("Japan")) {
                            bonus = 5;
                        }
                        break;
                    case 6:
                        if (customer.getAddress().contains("Thailand")) {
                            bonus = 5;
                        }
                        break;
                    default:
                        bonus = 2;
                }
                score = ScoreUtils.CalculateScoreForCenosCustomer(customer, bonus);
                if (score >= ScoreConstants.ASIA_CUT_OFF) {
                    eligibleCustomers.add(customer);
                }
            }
        } else {
            for (CustomerProfile customer : customers) {
                int bonus = 1;
                int score = 0;

                int code = 0;
                if (customer.getContactnumber() != null) {
                    code += 3;
                }
                if (customer.getAddress() != null) {
                    code += 2;
                }
                if (customer.getCustomername() != null) {
                    code += 1;
                }

                if (code == 0) {
                    bonus = 0;
                }
                if (code >= 5) {
                    bonus = 4;
                }
                score = ScoreUtils.CalculateScoreForCenosCustomer(customer, bonus);
                if (score >= ScoreConstants.INTERNATIONAL_CUT_OFF) {
                    eligibleCustomers.add(customer);
                }
            }
        }
        return eligibleCustomers;
    }

    public CustomerProfile getBackProfile(CustomerProfile customerProfile) {
        return customerProfile;
    }

    public List<CustomerScoreCardMap> getDummyScoreMaps() {
        CustomerProfile c = new CustomerProfile();
        CustomerProfile c1 = new CustomerProfile(1, "1", "1", "1", "1", "1");
        CustomerScoreCard customerScoreCard = new CustomerScoreCard(c, 0, false);
        CustomerScoreCard customerScoreCard1 = new CustomerScoreCard(c1, 100, true);

        List<CustomerScoreCard> scoreCards = Arrays.asList(customerScoreCard, customerScoreCard1);
        CustomerScoreCardMap map1 = new CustomerScoreCardMap(scoreCards);

        CustomerProfile c2 = new CustomerProfile();
        CustomerProfile c3 = new CustomerProfile(2, "2", "2", "2", "2", "2");
        CustomerScoreCard customerScoreCard2 = new CustomerScoreCard(c, 44, false);
        CustomerScoreCard customerScoreCard3 = new CustomerScoreCard(c1, 56, true);


        List<CustomerScoreCard> scoreCards2 = Arrays.asList(customerScoreCard2, customerScoreCard3);
        CustomerScoreCardMap map2 = new CustomerScoreCardMap(scoreCards2);

        return Arrays.asList(map1, map2);
    }
}
