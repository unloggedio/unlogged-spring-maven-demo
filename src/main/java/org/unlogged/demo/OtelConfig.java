package org.unlogged.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.opentelemetry.api.trace.Span;

public class OtelConfig {

    private static ObjectMapper instance;

    static {
        instance = new ObjectMapper();
        instance.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static void makeSpan(Span span, String keyValue, Object objectValue) {

        try {
            String objectString = instance.writeValueAsString(objectValue);
            span.setAttribute(keyValue, objectString);
        }
        catch (JsonProcessingException e){
            e.printStackTrace();
            span.setAttribute(keyValue, "null");
        }
    }

}
