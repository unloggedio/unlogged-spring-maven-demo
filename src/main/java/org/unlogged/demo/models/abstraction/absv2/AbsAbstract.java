package org.unlogged.demo.models.abstraction.absv2;

public abstract class AbsAbstract implements AbsInterface {

    private AbsPayload payload;

    public AbsAbstract(AbsPayload payload) {
        this.payload = payload;
    }

    @Override
    public String getVersionText() {
        return payload.getVersion();
    }
}
