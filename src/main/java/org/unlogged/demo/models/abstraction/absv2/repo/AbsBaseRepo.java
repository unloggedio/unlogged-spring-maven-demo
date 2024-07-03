package org.unlogged.demo.models.abstraction.absv2.repo;

import org.unlogged.demo.models.abstraction.absv2.AbsInterface;

public interface AbsBaseRepo<T extends AbsInterface> {

    T getAbsBase();

    String getVersion();
}
