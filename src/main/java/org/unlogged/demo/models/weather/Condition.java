package org.unlogged.demo.models.weather;

import lombok.Data;

@Data
public class Condition {
    public String text;
    public String icon;
    public int code;
}