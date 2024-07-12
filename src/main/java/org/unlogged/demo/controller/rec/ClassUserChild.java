package org.unlogged.demo.controller.rec;

import org.unlogged.demo.jspdemo.wfm.Models.Entities.User;

public class ClassUserChild extends ClassUserParent {

    private User user;

    public ClassUserChild(User user) {
        super();
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        super.setUser(user);
        this.user = user;
    }
}
