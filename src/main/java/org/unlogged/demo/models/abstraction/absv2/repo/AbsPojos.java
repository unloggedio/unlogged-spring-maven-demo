package org.unlogged.demo.models.abstraction.absv2.repo;

import org.springframework.stereotype.Component;
import org.unlogged.demo.models.abstraction.absv2.AbsPayload;
import org.unlogged.demo.models.abstraction.absv2.AbsPojoMain;

@Component
public class AbsPojos implements AbsBaseRepo<AbsPojoMain> {

    private final AbsPojoMain absPojoMain = new AbsPojoMain(new AbsPayload("v1"), "m1");

    @Override
    public AbsPojoMain getAbsBase() {
        return absPojoMain;
    }

    @Override
    public String getVersion() {
        return absPojoMain.getVersionText();
    }
}
