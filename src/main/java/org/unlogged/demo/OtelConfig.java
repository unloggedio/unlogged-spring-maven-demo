package org.unlogged.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        // case when object is MultipartFile
        else if (objectValue instanceof MultipartFile) {

            MultipartFile file = (MultipartFile) objectValue;

            byte[] fileBytes;
            try {
                fileBytes = file.getBytes();
            } catch (Exception e) {
                fileBytes = null;
                e.printStackTrace();
            }

            // TODO: file name is incorrect
            OtelFile otelFile = new OtelFile(file.getName(), fileBytes);
            objectValue = otelFile;
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

}
