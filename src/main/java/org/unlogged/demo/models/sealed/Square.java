package org.unlogged.demo.models.sealed;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Data
@Getter
public non-sealed class Square extends Shape {
   public double side;
}   