package org.unlogged.demo.models.sealed;

public sealed class Shape
    permits Circle, Square, Rectangle {
}