package org.unlogged.demo.utils;

import org.unlogged.demo.models.CustomerProfile;

public class ScoreUtils {
    public static int CalculateScoreForCenosCustomer(CustomerProfile profile, int bonus) {
        return profile.getContactnumber() != null ? 6 * bonus : 2 * bonus;
    }
}
