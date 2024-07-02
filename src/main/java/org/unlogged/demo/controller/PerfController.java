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
        span.end();
        return "server up!";
    }

    @RequestMapping("/cpuintensive")
    public long cpu(@RequestParam long value) {
        Span span = tracer.spanBuilder("custom_tracer").startSpan();
        span.setAttribute("requestParam.value", value);
        long val =  perfService.getCpuIntensiveData(value);
        span.setAttribute("responseValue.output", val);
        span.end();
        return val;
    }

    @RequestMapping("/memoryintensive")
    public long memoryIntensive(@RequestParam int count) {
        return perfService.sum_natural(count);
    }

    @RequestMapping("/databaseintensive")
    public String databaseintensive(@RequestParam int count) {
        return perfService.readWriteInDatabase(count);
    }

    @RequestMapping("/networkintensive")
    public String networkintensive(@RequestParam int count) {
        return perfService.genManyNetworkCall(count);
    }

}
