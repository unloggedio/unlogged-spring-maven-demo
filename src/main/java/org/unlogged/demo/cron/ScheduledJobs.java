package org.unlogged.demo.cron;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.unlogged.demo.controller.GreetingController;
import org.unlogged.demo.jspdemo.wfm.Models.Entities.User;

import java.util.Date;

@Component
public class ScheduledJobs {

    @Scheduled(fixedDelay = 10000, initialDelay = 1000)
    public void scheduleFixedDelayTask() {
        System.out.println(
                "Fixed delay task");
    }

    @Async
    @Scheduled(fixedRate = 10000)
    public void scheduleFixedRateTaskAsync() throws InterruptedException {
        System.out.println(
                "Async scheduled");
        Thread.sleep(10000);
    }

    @Scheduled(cron = "* * * * * *")
    public User cron1() {
        return new User(1, "u", "u", "u");
    }

    @Scheduled(cron = "0 * * * * *")
    public void cron2Greet() {
        System.out.println("Hourly");
        Date now = new Date();
        if (now.getHours() < 6 && now.getHours() > 22) {
            GreetingController.day = false;
        } else {
            GreetingController.day = true;
        }
    }
}
