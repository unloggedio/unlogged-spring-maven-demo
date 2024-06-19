package org.unlogged.demo.models.abstraction;

import lombok.Getter;

public enum RoomType {
    PROPERTY("You book the whole property"),
    PRIVATE_ROOM("Book rooms that can only be accessed by you or those travelling with you"),
    DORM_ROOM("Book rooms that can be accessed by others"),
    CAMP_SPACE("Book a camping spot");

    @Getter
    private String description;

    RoomType(String description) {
        this.description = description;
    }
}
