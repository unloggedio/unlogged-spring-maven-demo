package org.unlogged.demo.jspdemo.wfm.Services;

import org.unlogged.demo.jspdemo.wfm.Dao.CustomerProfileDao;
import org.unlogged.demo.jspdemo.wfm.Models.Entities.CustomerProfile;
import org.unlogged.demo.jspdemo.wfm.Models.Entities.CustomerProfileRequest;
import org.unlogged.demo.jspdemo.wfm.Models.Entities.CustomerScoreCard;
import org.unlogged.demo.jspdemo.wfm.ReferralUtils;
import org.unlogged.demo.jspdemo.wfm.ScoreConstants;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    private CustomerProfileDao customerProfileDao = new CustomerProfileDao();

    public CustomerProfile fetchCustomerProfile(long id) {
        return customerProfileDao.fetchCustomerProfile(id);
    }

    public CustomerProfile saveNewCustomer(CustomerProfileRequest saveRequest) {
        List<String> codes = generateReferralCodes();
        saveRequest.setCodes(codes);
        return customerProfileDao.save(saveRequest);
    }

    public CustomerProfile removeCustomer(long customerID) {
        return customerProfileDao.removeCustomer(customerID);
    }

    public CustomerProfile addNewContact(long customerID, String number) {
        CustomerProfile profile = customerProfileDao.fetchCustomerProfile(customerID);
        profile.getContactNumbers().add(number);
        customerProfileDao.save(profile);
        return profile;
    }

    public CustomerProfile generateReferralForCustomer(long customerID) {
        CustomerProfile profile = customerProfileDao.fetchCustomerProfile(customerID);
        profile.getReferralCodes().add(ReferralUtils.generateReferralCode());
        customerProfileDao.save(profile);
        return profile;
    }

    private List<String> generateReferralCodes() {
        int codeCount = 5;
        List<String> codes = new ArrayList<>();
        for (int i = 0; i < codeCount; i++) {
            codes.add(ReferralUtils.generateReferralCode());
        }
        return codes;
    }

    public CustomerScoreCard isCustomerEligibleForPremium(long customerID) {
        CustomerProfile profile = customerProfileDao.fetchCustomerProfile(customerID);
        int score = 0, bonus = 0;
        boolean isEligible = false;
        if (profile.getAddress().contains("Ohio") ||
                profile.getAddress().contains("Virginia") ||
                profile.getAddress().contains("Texas")) {
            bonus = 2;
        } else {
            bonus = 1;
        }
        score += profile.getReferralCodes().size() * (bonus + ScoreConstants.SCORE_PER_REFERRAL);
        if (score >= ScoreConstants.PREMIUM_CUT_OFF) {
            isEligible = true;
        }
        return new CustomerScoreCard(profile, score, isEligible);
    }
}
