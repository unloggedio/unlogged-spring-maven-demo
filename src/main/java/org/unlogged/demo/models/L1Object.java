package org.unlogged.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class L1Object {
    private String uuid;
    private int id;
    private String name;
    private L2Object1 make;
    private L2Object2 model;
}
