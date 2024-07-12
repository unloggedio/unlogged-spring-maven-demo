package org.unlogged.demo.service.abstractions;

public abstract class BaseCrudService<R> {
    protected R mappedRepository;

    protected String version;

    public void setVersion(String version) {
        this.version = version;
    }
}
