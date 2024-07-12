package org.unlogged.demo.controller.abstractions;

import org.unlogged.demo.models.abstraction.PropertyDetails;
import org.unlogged.demo.service.abstractions.CrudService;
import org.unlogged.demo.service.abstractions.PropertyService;

public abstract class BaseCrudController<S> {

    protected S mappedCrudService;

    protected String version;

    public BaseCrudController(S propertyService) {
        this.mappedCrudService = propertyService;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
