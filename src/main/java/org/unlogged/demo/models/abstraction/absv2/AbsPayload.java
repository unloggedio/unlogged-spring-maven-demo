package org.unlogged.demo.models.abstraction.absv2;

public class AbsPayload {
    private String version;

    public AbsPayload(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
