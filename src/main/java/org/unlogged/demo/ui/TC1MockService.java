package org.unlogged.demo.ui;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.unlogged.demo.jspdemo.wfm.Models.Entities.User;

@Service
@Component
public class TC1MockService {

    public User getUser() {
        return new User(44, "user44", "p44", "e44@gmail.com");
    }

    public String getAString() {
        return "RandomString";
    }
}
