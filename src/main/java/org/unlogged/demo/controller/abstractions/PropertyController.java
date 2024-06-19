package org.unlogged.demo.controller.abstractions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unlogged.demo.models.abstraction.PropertyDetails;
import org.unlogged.demo.service.abstractions.PropertyService;

@RestController
@RequestMapping("/property")
public class PropertyController extends PropertyControllerImpl {

    @Autowired
    public PropertyController(PropertyService<PropertyDetails, Long> propertyService) {
        super(propertyService);
    }
}
