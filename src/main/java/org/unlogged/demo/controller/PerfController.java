package org.unlogged.demo.controller;

import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.unlogged.demo.jspdemo.wfm.Controllers.BigObjController;
import org.unlogged.demo.jspdemo.wfm.Models.Entities.BigPojo;
import org.unlogged.demo.jspdemo.wfm.Models.Entities.User;
import org.unlogged.demo.jspdemo.wfm.Services.UserService;
import org.unlogged.demo.service.PerfService;

import java.time.Instant;
import java.util.ArrayList;


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

    @RequestMapping("/memoryintensive1")
    public long memoryIntensive1(@RequestParam int count) {
        return perfService.sum_natural(count);
    }

    @RequestMapping("/memoryintensive2")
    public String memoryIntensive2(@RequestParam int count) {
        return perfService.readWriteInMemory(count);
    }

    @RequestMapping("/networkintensive")
    public String networkintensive(@RequestParam int count) {
        return perfService.genManyNetworkCall(count);
    }

    @RequestMapping("/databaseintensive")
    public String databaseintensive(@RequestParam int count) {
        return perfService.genDatabaseIntensive(count);
    }

    @RequestMapping("/dataIntensive")
    public String dataIntensive(int count) {
        // This method triggers a method with many large pojos as input
        // That method has many external calls. This benchmarks OTEL span data collection performance

        ArrayList<BigPojo> dataList = new ArrayList<>();
        for (int i=0;i<=count-1;i++) {
            BigPojo bigPojo = new BigPojo(i);
            dataList.add(bigPojo);
        }

        return perfService.dataIntensive(dataList);
    }
}
