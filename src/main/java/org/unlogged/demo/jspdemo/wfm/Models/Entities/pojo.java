package org.unlogged.demo.jspdemo.wfm.Models.Entities;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class pojo {
    int id;

    long x;
    String name = "a";

    public int getId() {
        return id;
    }

    public long getx()
    {
        return x;
    }
}
