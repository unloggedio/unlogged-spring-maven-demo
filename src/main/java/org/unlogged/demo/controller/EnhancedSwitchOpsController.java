package org.unlogged.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unlogged.demo.jspdemo.wfm.Models.Entities.User;
import org.unlogged.demo.models.enswitch.Result;
import org.unlogged.demo.models.enswitch.Error;

import static java.lang.StringTemplate.STR;

@RestController
@RequestMapping("/enswitch")
public class EnhancedSwitchOpsController {

    public record Point(int x, int y) {
    }

    public String printQuadrant(Point p) {
        switch (p) {
            case Point(var x, var y) when x > 0 && y > 0 -> {
                return "First";
            }
            default -> {
                return "Second";
            }
        }
    }

    public String error() {
        switch (findUser()) {
            case Result.Success<?, User> success -> {
                return (STR. "User name is \{ success.value().getUsername() }" );
            }
            case Result.Failure<Error, ?> failure -> {
                return STR. "Error \{ failure.error().toString() }" ;
            }
        }
    }

    private Result<Error, User> findUser() {
        return new Result.Failure<>(
                new Error.OtherError(new RuntimeException("de error!"))
        );
    }

    public Integer switchJDK21(Object operation, int a, int b) {
        Integer answer = switch (operation) {
            case String s when s == "+" -> (a + b);
            case String s when s == "-" -> (a - b);
            case Integer i -> (i + i);
            case null -> (0);
            default -> (a * b);
        };
        return answer;

    }
}
