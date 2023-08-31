package io.unlogged.unloggedDemo.utils;

import java.util.Random;

import static io.unlogged.unloggedDemo.constants.ReferralConstants.*;

public class ReferralUtils {

    public static String generateReferralCode() {
        Random random = new Random();
        String generatedString = random.ints(REFERRAL_LEFT_LIMIT, REFERRAL_RIGHT_LIMIT + 1)
                .limit(REFERRAL_LENGTH)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }
}
