package org.unlogged.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class L2Object2 {
    private int l22Id;
    private L3Object l3SubModel;
}
