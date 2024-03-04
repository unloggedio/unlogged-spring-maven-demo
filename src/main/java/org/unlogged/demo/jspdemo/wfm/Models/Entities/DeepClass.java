package org.unlogged.demo.jspdemo.wfm.Models.Entities;


import java.util.List;

public class DeepClass {
    int x = 10;
    float f = 12.0f;
    double d = 24.0;
    String e = "e";
    private List<DeepClass> listOfPojos;
    private User user;
    private List<User> users;

    public boolean getE() {
        return true;
    }

    @Override
    public String toString() {
        return "pojoF{" +
                "x=" + x +
                ", f=" + f +
                ", d=" + d +
                ", e='" + e + '\'' +
                '}';
    }
}
