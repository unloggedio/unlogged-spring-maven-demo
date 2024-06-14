package org.unlogged.demo.models;

public class ItemInfo {
    private String name;
    private boolean large;

    public ItemInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLarge() {
        return large;
    }

    public void setLarge(boolean large) {
        this.large = large;
    }
}