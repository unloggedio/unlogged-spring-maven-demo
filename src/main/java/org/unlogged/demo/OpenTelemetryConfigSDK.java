package org.unlogged.demo;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.export.BatchSpanProcessor;
import io.opentelemetry.exporter.otlp.trace.OtlpGrpcSpanExporter;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.concurrent.TimeUnit;

@Configuration
@Profile("sdk")
public class OpenTelemetryConfigSDK {

    @Value("${otel.exporter.jaeger.endpoint}")
    private String jaegerEndpoint;

    @Value("${otel.service.name}")
    private String serviceName;

    @Bean
    public OpenTelemetry initOpenTelemetry() {

        // Define exporter Jaeger config
        SpanExporter spanExporter = OtlpGrpcSpanExporter.builder()
                .setEndpoint(jaegerEndpoint)
                .build();

        // Define tracerProvider
        SdkTracerProvider tracerProvider = SdkTracerProvider.builder()
                .addSpanProcessor(BatchSpanProcessor.builder(spanExporter)
                        .setScheduleDelay(100, TimeUnit.MILLISECONDS)
                        .build())
                .build();

        // Define openTelemetry
        OpenTelemetry openTelemetry = OpenTelemetrySdk.builder()
                .setTracerProvider(tracerProvider)
                .buildAndRegisterGlobal();

        return openTelemetry;
    }


//    @Bean
//    public Tracer tracer (OpenTelemetry openTelemetry) {
//
//        // Define tracer
//        return openTelemetry.getTracer(serviceName);
//    }
//
//    TODO: use this like this
//    private static Tracer tracer;
//    public PerfController(tracer tracer) {
//        this.tracer = tracer;
//    }
}