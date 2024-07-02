package org.unlogged.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.opentelemetry.api.trace.Span;
import org.springframework.web.multipart.MultipartFile;

import java.net.http.HttpResponse;

public class OtelConfig {

    private static ObjectMapper instance;

    static {
        instance = new ObjectMapper();
    }

    public static void makeSpan(Span span, String keyValue, Object objectValue) {

        // case when object is HTTP response
        if (objectValue instanceof HttpResponse) {
            try {
                HttpResponse<?> httpResponse = (HttpResponse<?>) objectValue;
                objectValue = httpResponse.body();
            } catch (Exception e) {
                objectValue = null;
                e.printStackTrace();
            }
        }

        // serialise object
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
