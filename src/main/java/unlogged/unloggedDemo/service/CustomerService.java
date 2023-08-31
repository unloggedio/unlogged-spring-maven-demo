package unlogged.unloggedDemo.service;

import unlogged.unloggedDemo.models.CustomerProfile;
import unlogged.unloggedDemo.models.CustomerProfileRequest;
import unlogged.unloggedDemo.models.CustomerScoreCard;
import unlogged.unloggedDemo.storage.CustomerProfileStore;

import java.util.ArrayList;
import java.util.List;

import static unlogged.unloggedDemo.constants.ScoreConstants.PREMIUM_CUT_OFF;
import static unlogged.unloggedDemo.constants.ScoreConstants.SCORE_PER_REFERRAL;
import static unlogged.unloggedDemo.utils.ReferralUtils.generateReferralCode;

public class CustomerService {
    private CustomerProfileStore customerProfileStore = new CustomerProfileStore();

    public CustomerProfile fetchCustomerProfile(long id) {
        return customerProfileStore.fetchCustomerProfile(id);
    }

    public CustomerProfile saveNewCustomer(CustomerProfileRequest saveRequest) {
        List<String> codes = generateReferralCodes();
        saveRequest.setCodes(codes);
        return customerProfileStore.save(saveRequest);
    }

    public CustomerProfile removeCustomer(long customerID) {
        return customerProfileStore.removeCustomer(customerID);
    }

    public CustomerProfile generateReferralForCustomer(long customerID) {
        CustomerProfile profile = customerProfileStore.fetchCustomerProfile(customerID);
        profile.getReferralCodes().add(generateReferralCode());
        customerProfileStore.save(profile);
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
        CustomerProfile profile = customerProfileStore.fetchCustomerProfile(customerID);
        int score = 0, bonus = 0;
        boolean isEligible = false;
        if (profile.getAddress().contains("Ohio") ||
                profile.getAddress().contains("Virginia") ||
                profile.getAddress().contains("Texas")) {
            bonus = 2;
        } else {
            bonus = 1;
        }
        score += profile.getReferralCodes().size() * (bonus + SCORE_PER_REFERRAL);
        if (score >= PREMIUM_CUT_OFF) {
            isEligible = true;
        }
        return new CustomerScoreCard(profile, score, isEligible);
    }
}
