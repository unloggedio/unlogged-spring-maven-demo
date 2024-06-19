package org.unlogged.demo.controller.abstractions;

import org.unlogged.demo.models.abstraction.PropertyDetails;
import org.unlogged.demo.service.abstractions.CrudService;
import org.unlogged.demo.service.abstractions.PropertyService;

public class BaseCrudController<S> {

    protected S mappedCrudService;

    public BaseCrudController(S propertyService) {
        this.mappedCrudService = propertyService;
    }
}
