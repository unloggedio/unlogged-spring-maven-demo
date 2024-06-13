package org.unlogged.demo.models.sealed;

import lombok.Data;

public final class FilledRectangle extends Rectangle {
    public int red, green, blue;

    public FilledRectangle(double length, double width) {
        super(length, width);
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }
}