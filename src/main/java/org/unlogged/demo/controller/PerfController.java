package org.unlogged.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.unlogged.demo.service.PerfService;


@RestController
@RequestMapping("/perf")
public class PerfController {

	@Autowired
    private PerfService perfService;

    @RequestMapping("/ping")
    public String ping() {
        return "server up!";
    }

    @RequestMapping("/cpuintensive")
    public long cpu(@RequestParam long value) {
        return perfService.getCpuIntensiveData(value);
    }

    @RequestMapping("/memoryintensive")
    public long memoryIntensive(@RequestParam int count) {
        return perfService.sum_natural(count);
    }

    @RequestMapping("/networkintensive")
    public String networkintensive(@RequestParam int count) {
        return perfService.genManyNetworkCall(count);
    }

    @RequestMapping("/databaseintensive")
    public String databaseintensive(@RequestParam int count) {
        return perfService.genDatabaseIntensive(count);
    }
}
