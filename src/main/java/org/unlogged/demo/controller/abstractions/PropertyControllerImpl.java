package org.unlogged.demo.controller.abstractions;

import org.unlogged.demo.models.abstraction.PropertyDetails;
import org.unlogged.demo.service.abstractions.PropertyService;

import java.util.List;

public class PropertyControllerImpl extends BaseCrudController<PropertyService<PropertyDetails, Long>> implements CrudController<PropertyDetails, Long> {
    public PropertyControllerImpl(PropertyService<PropertyDetails, Long> propertyService) {
        super(propertyService);
    }

    @Override
    public PropertyDetails findById(Long id) {
        return mappedCrudService.getById(id);
    }

    @Override
    public List<PropertyDetails> findAll() {
        return mappedCrudService.getAll();
    }

    @Override
    public PropertyDetails insertNew(PropertyDetails propertyDetails) {
        return mappedCrudService.insertNew(propertyDetails);
    }

    @Override
    public PropertyDetails update(PropertyDetails propertyDetails) {
        return mappedCrudService.updateExisting(propertyDetails);
    }

    @Override
    public PropertyDetails deleteById(Long id) {
        return mappedCrudService.deleteById(id);
    }

    public void setVersion() {
        super.setVersion("E");
        version = "E";
    }
}
