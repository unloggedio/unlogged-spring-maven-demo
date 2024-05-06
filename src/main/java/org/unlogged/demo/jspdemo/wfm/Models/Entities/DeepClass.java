package org.unlogged.demo.jspdemo.wfm.Models.Entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DeepClass {
    int x = 10;
    float f = 12.0f;
    double d = 24.0;
    String e = "e";
    private List<DeepNode> listOfPojos;
    private User user;
    private List<User> users;

    public DeepClass(List<User> users) {
        this.users = users;
        this.user = users.get(0);

        this.listOfPojos = users.stream().map(e -> {
            return new DeepNode(this, e);
        }).collect(Collectors.toList());
    }

    public boolean getE() {
        return true;
    }

    @Override
    public String toString() {
        return "DeepClass{" +
                "x=" + x +
                ", f=" + f +
                ", d=" + d +
                ", e='" + e + '\'' +
                ", listOfPojos=" + listOfPojos +
                ", user=" + user +
                ", users=" + users +
                '}';
    }
}
