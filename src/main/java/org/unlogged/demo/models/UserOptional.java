package org.unlogged.demo.models;

import java.util.Optional;

public class UserOptional {
    private String name;
    private String email;
    private String number;

    public UserOptional(String name, String email, String number) {
        this.name = name;
        this.email = email;
        this.number = number;
    }

    public UserOptional() {
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Optional<String> getNumber() {
        return Optional.ofNullable(number);
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
