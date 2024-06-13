package org.unlogged.demo.models.sealed;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public final class Circle extends Shape {
    public float radius;
}