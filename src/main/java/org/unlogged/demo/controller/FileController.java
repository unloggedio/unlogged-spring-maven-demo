package org.unlogged.demo.controller;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.unlogged.demo.OtelConfig.makeSpan;
import static org.unlogged.demo.OtelConfig.makeSpanForFile;

@RestController
@RequestMapping("/file")
public class FileController {

    private final Tracer tracer = GlobalOpenTelemetry.getTracer("unlogged-spring-maven-demo");

    private static String UPLOADED_FOLDER = "./uploads/";

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {

        Span span = tracer.spanBuilder("custom_tracer").startSpan();
        makeSpanForFile(span,"input.file", file);

        if (file.isEmpty()) {

            ResponseEntity<String> response = new ResponseEntity<>("Please select a file to upload", HttpStatus.BAD_REQUEST);
            makeSpan(span, "output", response);
            span.end();
            return response;
        }

        try {
            File uploadDir = new File(UPLOADED_FOLDER);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            ResponseEntity<String> response = new ResponseEntity<>("Successfully uploaded - " + file.getOriginalFilename(), HttpStatus.OK);
            makeSpan(span, "output", response);
            span.end();
            return response;

        } catch (IOException e) {
            e.printStackTrace();

            ResponseEntity<String> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            makeSpan(span, "output", response);
            span.end();
            return response;
        }
    }
}
