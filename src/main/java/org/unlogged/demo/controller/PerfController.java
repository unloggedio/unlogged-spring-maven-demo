package org.unlogged.demo.controller;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.unlogged.demo.service.PerfService;


@RestController
@RequestMapping("/perf")
public class PerfController {

    private final Tracer tracer;

    @Autowired
    public PerfController(Tracer tracer) {
        this.tracer = tracer;
    }

	@Autowired
    private PerfService perfService;

    @RequestMapping("/ping")
    public String ping() {
        Span span = tracer.spanBuilder("custom_tracer").startSpan();

        String s = "server up!";
        span.setAttribute("output", s);

        span.end();
        return s;
    }

    @RequestMapping("/cpuintensive")
    public long cpu(@RequestParam long value) {
        Span span = tracer.spanBuilder("custom_tracer").startSpan();
        span.setAttribute("input.value", value);

        long val =  perfService.getCpuIntensiveData(value);

        span.end();
        return val;
    }

    @RequestMapping("/memoryintensive")
    public long memoryIntensive(@RequestParam int count) {
        Span span = tracer.spanBuilder("custom_tracer").startSpan();
        span.setAttribute("input.count", count);

        long val =  perfService.sum_natural(count);

        span.end();
        return val;
    }

    @RequestMapping("/databaseintensive")
    public String databaseintensive(@RequestParam int count) {
        Span span = tracer.spanBuilder("custom_tracer").startSpan();
        span.setAttribute("input.count", count);

        String val = perfService.readWriteInDatabase(count);

        span.end();
        return val;
    }

    @RequestMapping("/networkintensive")
    public String networkintensive(@RequestParam int count) {
        Span span = tracer.spanBuilder("custom_tracer").startSpan();
        span.setAttribute("input.count", count);

        String value = perfService.genManyNetworkCall(count);

        span.end();
        return value;
    }

}
