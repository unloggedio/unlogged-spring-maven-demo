package org.unlogged.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stringmethods")
public class StringMethodsJava11Controller {

    @GetMapping("/isBlank")
    public Boolean isBlank(@RequestParam String input) {
        return input.isBlank();
    }

    @PostMapping("/lines")
    public String lines(@RequestBody String input) {
        return String.join(",", input.lines().toArray(String[]::new));
    }

    @PostMapping("/strip")
    public String strip(@RequestBody String input) {
        return input.strip();
    }

    @PostMapping("/stripLeading")
    public String stripLeading(@RequestBody String input) {
        return input.stripLeading();
    }

    @PostMapping("/stripTrailing")
    public String stripTrailing(@RequestBody String input) {
        return input.stripTrailing();
    }

    @PostMapping("/repeat")
    public String repeat(@RequestBody String input, @RequestParam int count) {
        return input.repeat(count);
    }
}

