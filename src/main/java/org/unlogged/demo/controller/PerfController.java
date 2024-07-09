package org.unlogged.demo.controller;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.unlogged.demo.jspdemo.wfm.Models.Entities.BigPojo;
import org.unlogged.demo.service.PerfService;

import java.util.ArrayList;

import static org.unlogged.demo.OtelConfig.makeSpan;
import static org.unlogged.demo.OtelConfig.registerMethod;


@RestController
@RequestMapping("/perf")
public class PerfController {

    private static final Tracer tracer = GlobalOpenTelemetry.getTracer("unlogged-spring-maven-demo");

	@Autowired
    private PerfService perfService;

    @RequestMapping("/ping")
    public String ping() {
        Span span = tracer.spanBuilder("custom_tracer.1").startSpan();

        String s = "server up!";

        span.end();
        return s;
    }

    @RequestMapping("/cpuintensive")
    public long cpu(@RequestParam long value) {
        Span span = tracer.spanBuilder("custom_tracer.2").startSpan();
        makeSpan(span, "input.value", value);

        long val =  perfService.getCpuIntensiveData(value);
        makeSpan(span, "mockData.1", val);

        span.end();
        return val;
    }

    @RequestMapping("/memoryintensive1")
    public long memoryIntensive1(@RequestParam int count) {
        Span span = tracer.spanBuilder("custom_tracer.3").startSpan();
        makeSpan(span, "input.count", count);

        long val =  perfService.sum_natural(count);
        makeSpan(span, "mockData.1", val);

        span.end();
        return val;
    }

    @RequestMapping("/memoryintensive2")
    public String memoryIntensive2(@RequestParam int count) {
        Span span = tracer.spanBuilder("custom_tracer.4").startSpan();
        makeSpan(span, "intput.count", count);

        String val = perfService.readWriteInMemory(count);
        makeSpan(span, "mockData.1", val);

        span.end();
        return val;
    }

    @RequestMapping("/networkintensive")
    public String networkintensive(@RequestParam int count) {
        Span span = tracer.spanBuilder("custom_tracer.5").startSpan();
        makeSpan(span, "input.count", count);

        String value = perfService.genManyNetworkCall(count);
        makeSpan(span, "mockData.1", value);

        span.end();
        return value;
    }

    @RequestMapping("/databaseintensive")
    public String databaseintensive(@RequestParam int count) {
        Span span = tracer.spanBuilder("custom_tracer.6").startSpan();
        makeSpan(span, "input.count", count);

        String value = perfService.genDatabaseIntensive(count);
        makeSpan(span, "mockData.1", value);

        makeSpan(span, "output", value);
        span.end();
        return value;
    }

    @RequestMapping("/dataIntensive")
    public String dataIntensive(int count) {
        Span span = tracer.spanBuilder("custom_tracer.7").startSpan();
        makeSpan(span, "input.count", count);
        // This method triggers a method with many large pojos as input
        // That method has many external calls. This benchmarks OTEL span data collection performance

        ArrayList<BigPojo> dataList = new ArrayList<>();
        for (int i=0;i<=count-1;i++) {
            BigPojo bigPojo = new BigPojo(i);
            makeSpan(span, "mockData." + count, bigPojo);
            dataList.add(bigPojo);
        }

        String s = perfService.dataIntensive(dataList);
        makeSpan(span, "output", s);
        span.end();
        return s;
    }

    static {
        Span span = tracer.spanBuilder("method_registration").startSpan();
        registerMethod(span, 1, "org.unlogged.demo.controller.PerfController", "ping", "", "java.lang.String", false, true, false, 1, "()Ljava/lang/String;");
        registerMethod(span, 2, "org.unlogged.demo.controller.PerfController", "cpu", "J", "J", false, true, false, 1, "(J)J");
        registerMethod(span, 3, "org.unlogged.demo.controller.PerfController", "memoryIntensive1", "I", "J", false, true, false, 1, "(I)J");
        registerMethod(span, 4, "org.unlogged.demo.controller.PerfController", "memoryIntensive2", "I", "java.lang.String", false, true, false, 1, "(I)Ljava/lang/String;");
        registerMethod(span, 5, "org.unlogged.demo.controller.PerfController", "networkintensive", "I", "java.lang.String", false, true, false, 1, "(I)Ljava/lang/String;");
        registerMethod(span, 6, "org.unlogged.demo.controller.PerfController", "databaseintensive", "I", "java.lang.String", false, true, false, 1, "(I)Ljava/lang/String;");
        registerMethod(span, 7, "org.unlogged.demo.controller.PerfController", "dataIntensive", "I", "java.lang.String", false, true, true, 1, "(I)Ljava/lang/String;");
        span.end();
    }
}
