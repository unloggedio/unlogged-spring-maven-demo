package org.unlogged.demo;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.export.BatchSpanProcessor;
import io.opentelemetry.exporter.otlp.trace.OtlpGrpcSpanExporter;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class OpenTelemetryConfig {

    private static Tracer tracer;

    @PostConstruct
    public void init() {

        // Jaeger config
        SpanExporter spanExporter = OtlpGrpcSpanExporter.builder()
                .setEndpoint("http://localhost:14250")
                .build();

        SdkTracerProvider tracerProvider = SdkTracerProvider.builder()
                .addSpanProcessor(BatchSpanProcessor.builder(spanExporter)
                        .setScheduleDelay(100, TimeUnit.MILLISECONDS)
                        .build())
                .build();

        // Build and register OpenTelemetry instance
        OpenTelemetrySdk openTelemetrySdk = OpenTelemetrySdk.builder()
                .setTracerProvider(tracerProvider)
                .buildAndRegisterGlobal();

        // use traces for implementation
        OpenTelemetry openTelemetry = GlobalOpenTelemetry.get();
        tracer = openTelemetry.getTracer("io.opentelemetry.example");
    }

    public static Tracer getTracer() {
        return tracer;
    }

}
