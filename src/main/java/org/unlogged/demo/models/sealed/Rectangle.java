package org.unlogged.demo.models.sealed;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public sealed class Rectangle extends Shape permits FilledRectangle {
    public double length, width;
}