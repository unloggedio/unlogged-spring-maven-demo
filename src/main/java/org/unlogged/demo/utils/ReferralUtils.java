package org.unlogged.demo.utils;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import org.unlogged.demo.constants.ReferralConstants;

import java.util.Random;

public class ReferralUtils {

    private static final Tracer tracer = GlobalOpenTelemetry.getTracer("unlogged-spring-maven-demo");

    public static String generateReferralCode() {
        Span span = tracer.spanBuilder("custom_tracer").startSpan();

        Random random = new Random();
        span.setAttribute("mockData.1", random.toString());

        String generatedString = random.ints(ReferralConstants.REFERRAL_LEFT_LIMIT, ReferralConstants.REFERRAL_RIGHT_LIMIT + 1)
                .limit(ReferralConstants.REFERRAL_LENGTH)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        span.setAttribute("mockData.2", generatedString);

        span.setAttribute("output", generatedString);
        span.end();
        return generatedString;
    }

    public static String generateReferralCode(int customLimit) {
        Random random = new Random();
        String generatedString = random.ints(customLimit, ReferralConstants.REFERRAL_RIGHT_LIMIT + 1)
                .limit(ReferralConstants.REFERRAL_LENGTH)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }
}
