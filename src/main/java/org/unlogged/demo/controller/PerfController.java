package org.unlogged.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.unlogged.demo.jspdemo.wfm.Models.Entities.User;
import org.unlogged.demo.jspdemo.wfm.Services.UserService;
import org.unlogged.demo.service.PerfService;

import java.time.Instant;


@RestController
@RequestMapping("/perf")
public class PerfController {

	@Autowired
    private PerfService perfService;

    @Autowired
    private UserService userService;

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

        // get base user id
        long baseId = userService.getCountOfUsers();

        // read to the database
        for (int i=0;i<=count-1;i++) {
            long userId = baseId + i;
            User user = new User(
                    userId,
                    "username-" + userId,
                    "password-" + userId,
                    "mail-" + userId
            );

            userService.addUser(user);
        }

        // read from the database
        StringBuilder dbResult = new StringBuilder();
        for (int i=0;i<=count-1;i++) {
            User user = userService.getUser(baseId + i);
            dbResult.append(user.toString());
        }

        return dbResult.toString();
    }
}
