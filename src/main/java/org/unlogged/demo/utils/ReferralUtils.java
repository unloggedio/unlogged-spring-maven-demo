package org.unlogged.demo.utils;

import org.unlogged.demo.constants.ReferralConstants;

import java.util.Random;

public class ReferralUtils {

    public static String generateReferralCode() {
        Random random = new Random();
        String generatedString = random.ints(ReferralConstants.REFERRAL_LEFT_LIMIT, ReferralConstants.REFERRAL_RIGHT_LIMIT + 1)
                .limit(ReferralConstants.REFERRAL_LENGTH)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }
}
