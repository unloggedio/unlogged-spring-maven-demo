package org.unlogged.demo.jspdemo.wfm.Models.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class DeepNode {

    private DeepClass parent;
    private User u;

    public DeepNode(DeepClass parent, User u) {
        this.parent = parent;
        this.u = u;
    }

    public DeepClass getParent() {
        return parent;
    }

    public void setParent(DeepClass parent) {
        this.parent = parent;
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

    @Override
    public String toString() {
        return "DeepNode{" +
                "parent=" + parent +
                ", u=" + u +
                '}';
    }
}
