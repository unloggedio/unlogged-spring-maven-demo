package org.unlogged.demo.utils;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import org.unlogged.demo.constants.ReferralConstants;

import java.util.Random;

import static org.unlogged.demo.OtelConfig.makeSpan;
import static org.unlogged.demo.OtelConfig.registerMethod;

public class ReferralUtils {

    private static final Tracer tracer = GlobalOpenTelemetry.getTracer("unlogged-spring-maven-demo");

    public static String generateReferralCode() {
        Span span = tracer.spanBuilder("custom_tracer.15").startSpan();

        Random random = new Random();
        makeSpan(span, "mockData.1", random);


        String generatedString = random.ints(ReferralConstants.REFERRAL_LEFT_LIMIT, ReferralConstants.REFERRAL_RIGHT_LIMIT + 1)
                .limit(ReferralConstants.REFERRAL_LENGTH)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        makeSpan(span, "mockData.2", generatedString);

        makeSpan(span, "output", generatedString);
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

    static {
        Span span = tracer.spanBuilder("method_registration").startSpan();
        registerMethod(span, 15, "org.unlogged.demo.utils.ReferralUtils", "generateReferralCode", "", "java.lang.String", true, true, true, 9, "()Ljava/lang/String;");
        span.end();
    }
}
