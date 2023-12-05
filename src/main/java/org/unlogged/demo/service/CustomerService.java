package org.unlogged.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unlogged.demo.constants.ScoreConstants;
import org.unlogged.demo.dao.CustomerProfileRepo;
import org.unlogged.demo.models.CustomerProfile;
import org.unlogged.demo.repository.CustomerProfileRepository;
import org.unlogged.demo.utils.ScoreUtils;
import org.unlogged.demo.models.CustomerProfileRequest;
import org.unlogged.demo.models.CustomerScoreCard;

import java.util.ArrayList;
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

    public CustomerProfile saveNewCustomer(CustomerProfileRequest saveRequest) {
        List<String> codes = generateReferralCodes();
        saveRequest.setCodes(codes);
        return customerProfileRepository.save(saveRequest);
    }

    public CustomerProfile removeCustomer(long customerID) {
        return customerProfileRepository.removeCustomer(customerID);
    }

    public CustomerProfile generateReferralForCustomer(long customerID) {
        CustomerProfile profile = customerProfileRepository.fetchCustomerProfile(customerID);
        profile.getReferralcodes().add(generateReferralCode());
        customerProfileRepository.save(profile);
        return profile;
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
        score += profile.getReferralcodes().size() * (bonus + ScoreConstants.SCORE_PER_REFERRAL);
        if (score >= ScoreConstants.PREMIUM_CUT_OFF) {
            isEligible = true;
        }
        return new CustomerScoreCard(profile, score, isEligible);
    }

    public List<CustomerProfile> filterEligbleCustomers(List<CustomerProfile> customers, boolean asiaFlow) {
        List<CustomerProfile> eligibleCustomers = new ArrayList<>();
        eligibleCustomers = customerProfileRepository.getAsianCustomers();
        if (asiaFlow) {
            for (CustomerProfile customer : customers) {
                int bonus = 0;
                int score = 0;
                switch (customer.getReferralcodes().size()) {
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

                if (customer.getReferralcodes().size() == 0) {
                    bonus = 0;
                }
                if (customer.getReferralcodes().size() >= 5) {
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
}
