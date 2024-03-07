package org.unlogged.demo.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DTOModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public CustomerProfileDTOAssembler personDTOModelAssembler() {
        return new CustomerProfileDTOAssembler();
    }
}