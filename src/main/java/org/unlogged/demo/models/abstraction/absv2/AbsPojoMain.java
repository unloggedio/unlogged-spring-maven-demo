package org.unlogged.demo.models.abstraction.absv2;

public class AbsPojoMain extends AbsAbstract {

    private String message;

    public AbsPojoMain(AbsPayload payload, String message) {
        super(payload);
    }

    public String getMessage() {
        return this.message;
    }

    public String getVersion() {
        return getVersionText();
    }
}
