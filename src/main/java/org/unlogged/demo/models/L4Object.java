package org.unlogged.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class L4Object {
    private String l4Name;
    private int l4Id;
    private float fv = 1.2f;
    private double dv = 2.3d;
}
