package org.unlogged.demo.models.enswitch;

public sealed interface Result<E, A> {

    record Success<E, A>(A value) implements Result<E, A> {
    }

    record Failure<E, A>(E error) implements Result<E, A> {
    }
}