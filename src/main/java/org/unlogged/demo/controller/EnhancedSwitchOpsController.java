//package org.unlogged.demo.controller;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.unlogged.demo.jspdemo.wfm.Models.Entities.User;
//import org.unlogged.demo.models.enswitch.Result;
//import org.unlogged.demo.models.enswitch.Error;
//
//import static java.lang.StringTemplate.STR;
//
//@RestController
//@RequestMapping("/enswitch")
//public class EnhancedSwitchOpsController {
//
//    public record Point(int x, int y) {
//    }
//
//    public String printQuadrant(Point p) {
//        switch (p) {
//            case Point(var x, var y) when x > 0 && y > 0 -> {
//                return "First";
//            }
//            default -> {
//                return "Second";
//            }
//        }
//    }
//
//    public String error() {
//        switch (findUser()) {
//            case Result.Success<?, User> success -> {
//                return (STR. "User name is \{ success.value().getUsername() }" );
//            }
//            case Result.Failure<Error, ?> failure -> {
//                return STR. "Error \{ failure.error().toString() }" ;
//            }
//        }
//    }
//
//    private Result<Error, User> findUser() {
//        return new Result.Failure<>(
//                new Error.OtherError(new RuntimeException("de error!"))
//        );
//    }
//
//    public Integer switchJDK21(Object operation, int a, int b) {
//        Integer answer = switch (operation) {
//            case String s when s == "+" -> (a + b);
//            case String s when s == "-" -> (a - b);
//            case Integer i -> (i + i);
//            case null -> (0);
//            default -> (a * b);
//        };
//        return answer;
//
//    }
//
//    @GetMapping("/case1/{input}")
//    public String processInput(@PathVariable String input) {
//        Object result = parseInput(input);
//        return handleResult(result);
//    }
//
//    @GetMapping("/case2/{input}")
//    public String processInputWithYield(@PathVariable String input) {
//        Object result = parseDouble(input);
//        return handleResultWithYield(result);
//    }
//
//    private Object parseInput(String input) {
//        if (input.startsWith("animal:")) {
//            return new Animal(input.substring(7));
//        }
//        try {
//            return Integer.parseInt(input);
//        } catch (NumberFormatException e) {
//            return input;
//        }
//    }
//
//    private Object parseDouble(String input) {
//        if (input.startsWith("animal:")) {
//            return new Animal(input.substring(7));
//        }
//        try {
//            return Double.parseDouble(input);
//        } catch (NumberFormatException e) {
//            return input;
//        }
//    }
//
//    private String handleResult(Object result) {
//        return switch (result) {
//            case Integer i -> "Processed an integer: " + (i * 2);
//            case String s when s.length() > 5 -> "Processed a long string: " + s.toUpperCase();
//            case String s -> "Processed a string: " + s;
//            case Animal a -> "Processed an animal: " + a.getName();
//            default -> "Unhandled type";
//        };
//    }
//
//    private String handleResultWithYield(Object result) {
//        return switch (result) {
//            case Double i -> {
//                yield "Processed an double with yield: " + (i * 2);
//            }
//            case String s when s.length() > 5 -> {
//                yield "Processed a long string with yield: " + s.toUpperCase();
//            }
//            case String s -> {
//                yield "Processed a string with yield: " + s;
//            }
//            case Animal a -> {
//                yield "Processed an animal with yield: " + a.getName();
//            }
//            default -> {
//                yield "Unhandled type with yield";
//            }
//        };
//    }
//    // Inner Animal class
//    static class Animal {
//        private String name;
//
//        public Animal(String name) {
//            this.name = name;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        @Override
//        public String toString() {
//            return STR."Animal{name='\{name}'}";
//        }
//    }
//}
