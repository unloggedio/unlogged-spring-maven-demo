package org.unlogged.demo;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Tracer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@Profile("agent")
public class OpenTelemetryConfigJAR {

    @Value("${otel.service.name}")
    private String serviceName;

    @Bean
    public Tracer tracer () {

        // Define tracer
        return GlobalOpenTelemetry.getTracer(serviceName);
    }
}
