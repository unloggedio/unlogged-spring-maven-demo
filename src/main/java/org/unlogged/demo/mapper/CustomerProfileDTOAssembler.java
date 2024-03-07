package org.unlogged.demo.mapper;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.unlogged.demo.jspdemo.wfm.Controllers.CustomerRes;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class CustomerProfileDTOAssembler implements RepresentationModelAssembler<CustomerDTO, EntityModel<CustomerDTO>> {
    @Override
    public EntityModel<CustomerDTO> toModel(CustomerDTO personDTO) {
        return EntityModel.of(personDTO,
                linkTo(methodOn(CustomerRes.class).getCustomerDto(personDTO.getId())).withSelfRel());
    }
}
