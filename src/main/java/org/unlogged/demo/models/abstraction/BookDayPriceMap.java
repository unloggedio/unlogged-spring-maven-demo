package org.unlogged.demo.models.abstraction;

public enum BookDayPriceMap {
    WEEKDAY(1.0),
    WEEKEND(1.15),
    HOLIDAY(1.20);

    private double defaultPriceMod;

    BookDayPriceMap(double mod) {
        this.defaultPriceMod = mod;
    }

    public double getDefaultPriceMod() {
        return this.defaultPriceMod;
    }

}
