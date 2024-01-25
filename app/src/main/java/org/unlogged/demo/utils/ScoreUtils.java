package org.unlogged.demo.utils;

import org.unlogged.demo.models.CustomerProfile;

public class ScoreUtils {
    public static int CalculateScoreForCenosCustomer(CustomerProfile profile, int bonus) {
        return profile.getReferralcodes().size() * bonus;
    }
}
