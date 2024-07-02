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
        span.setAttribute("mockData.1", val);

        span.setAttribute("output", val);
        span.end();
        return val;
    }

    @RequestMapping("/memoryintensive1")
    public long memoryIntensive1(@RequestParam int count) {
        Span span = tracer.spanBuilder("custom_tracer").startSpan();
        span.setAttribute("input.count", count);

        long val =  perfService.sum_natural(count);
        span.setAttribute("mockData.1", val);

        span.setAttribute("output", val);
        span.end();
        return val;
    }

    @RequestMapping("/memoryintensive2")
    public String memoryIntensive2(@RequestParam int count) {
        Span span = tracer.spanBuilder("custom_tracer").startSpan();
        span.setAttribute("input.count", count);

        String val = perfService.readWriteInDatabase(count);
        span.setAttribute("mockData.1", val);

        span.setAttribute("output", val);
        span.end();
        return val;
    }

    @RequestMapping("/networkintensive")
    public String networkintensive(@RequestParam int count) {
        Span span = tracer.spanBuilder("custom_tracer").startSpan();
        span.setAttribute("input.count", count);

        String value = perfService.genManyNetworkCall(count);
        span.setAttribute("mockData.1", value);

        span.setAttribute("output",  value);
        span.end();
        return value;
    }

}
