package org.unlogged.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.opentelemetry.api.trace.Span;
import org.springframework.web.multipart.MultipartFile;

public class OtelConfig {

    private static ObjectMapper instance;

    static {
        instance = new ObjectMapper();

        // TODO: should this be disabled?
        instance.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        instance.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
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

    public static void makeSpanForFile(Span span, String keyValue, MultipartFile fileName) {

        // TODO: create a json here
        String fileContent;
        try {
            byte[] fileBytes = fileName.getBytes();
            fileContent = new String(fileBytes);
        } catch (Exception e) {
            System.out.println("error reading file content");
            fileContent = "error reading file content";
        }

        span.setAttribute(keyValue, fileContent);
    }

}
