package org.unlogged.demo.models.enswitch;

public sealed interface Error {

    record UserNotFound(String userName) implements Error {
    }

    record OtherError(Throwable cause) implements Error {
    }
}