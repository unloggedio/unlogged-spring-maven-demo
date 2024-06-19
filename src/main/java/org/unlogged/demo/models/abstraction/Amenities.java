package org.unlogged.demo.models.abstraction;

import lombok.Getter;

public enum Amenities {
    AC("Air conditioner", "get an ac"),
    TV("TV", "you get a tv"),
    WASHING_MACHINE("Washing machine", "You'll get a washing machine"),
    FRIDGE("fridge", "you'll get a fridge"),
    SWIMMING_POOL("swimming pool", "you'll get a pool"),
    WIFI("Wifi", "You'll get wifi access"),
    PARKING_SPACE("Parking space", "You'll get parking space for your vehicles"),
    CARETAKER_SERVICES("Caretaker services", "Caretaker will be available for housekeeping");

    @Getter
    private String name;
    @Getter
    private String description;

    Amenities(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
