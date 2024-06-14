package org.unlogged.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    public static boolean day = true;

    @RequestMapping("/greet")
    public String getGreeting() {
        return "Good " + ((day) ? "Day" : "Night");
    }
}
