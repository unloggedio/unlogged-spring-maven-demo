package org.unlogged.demo.service.abstractions;

import org.springframework.stereotype.Service;
import org.unlogged.demo.models.abstraction.PropertyDetails;

@Service
public class PropertyServiceImpl extends PropertyServiceCEImpl implements PropertyService<PropertyDetails, Long> {
}
