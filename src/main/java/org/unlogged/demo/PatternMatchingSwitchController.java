package org.unlogged.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/switch")
public class PatternMatchingSwitchController {

    // Inner Animal class
    static class Animal {
        private String name;

        public Animal(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Animal{name='" + name + "'}";
        }
    }

    @GetMapping("/case1/{input}")
    public String processInput(@PathVariable String input) {
        Object result = parseInput(input);
        return handleResult(result);
    }

    @GetMapping("/case2/{input}")
    public String processInputWithYield(@PathVariable String input) {
        Object result = parseInput(input);
        return handleResultWithYield(result);
    }

    private Object parseInput(String input) {
        if (input.startsWith("animal:")) {
            return new Animal(input.substring(7));
        }
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return input;
        }
    }

    private String handleResult(Object result) {
        return switch (result) {
            case Integer i -> "Processed an integer: " + (i * 2);
            case String s when s.length() > 5 -> "Processed a long string: " + s.toUpperCase();
            case String s -> "Processed a string: " + s;
            case Animal a -> "Processed an animal: " + a.getName();
            default -> "Unhandled type";
        };
    }

    private String handleResultWithYield(Object result) {
        return switch (result) {
            case Integer i -> {
                yield "Processed an integer with yield: " + (i * 2);
            }
            case String s when s.length() > 5 -> {
                yield "Processed a long string with yield: " + s.toUpperCase();
            }
            case String s -> {
                yield "Processed a string with yield: " + s;
            }
            case Animal a -> {
                yield "Processed an animal with yield: " + a.getName();
            }
            default -> {
                yield "Unhandled type with yield";
            }
        };
    }
}
