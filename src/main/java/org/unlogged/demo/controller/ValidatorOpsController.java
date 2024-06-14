package org.unlogged.demo.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unlogged.demo.jspdemo.wfm.Models.Entities.User;
import org.unlogged.demo.models.valid.UserV2;
import org.unlogged.demo.validator.UserValidator;

import java.util.Map;

@RestController
@RequestMapping("/validators")
public class ValidatorOpsController {

    @Autowired
    private UserValidator userValidator;

    @InitBinder(value = "user")
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(userValidator);
    }

    private User getValidUser() {
        return new User(1, "User", "password", "user@usermail.com");
    }

    @RequestMapping("/vaild")
    public boolean isDefaultUserVaild() {
        return isUserValid(getValidUser());
    }

    public boolean isUserValid(@Valid User user) {
        return true;
    }

    @RequestMapping("/validv2")
    public Map<UserV2, Boolean> validateUserV2(@Valid @RequestBody UserV2 userV2) {
        return Map.of(userV2, true);
    }
}
