package org.unlogged.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.A;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class L3Object {
    private int l3Id;
    private String l3Name;
    private L4Object l4Object;
}
