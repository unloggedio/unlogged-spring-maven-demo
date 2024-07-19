package org.unlogged.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import jakarta.persistence.EntityManagerFactory;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.unlogged.demo.models.session.Department;
import org.unlogged.demo.models.session.DepartmentDTO;

@SpringBootApplication
@EnableTransactionManagement
public class UnloggedDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnloggedDemoApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper(EntityManagerFactory emFactory) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setPropertyCondition(context -> emFactory.getPersistenceUnitUtil().isLoaded(context.getSource()));
        mapper.typeMap(Department.class, DepartmentDTO.class).addMappings(new PropertyMap<Department, DepartmentDTO>() {
            @Override
            protected void configure() {
                map().setLocation(null);
            }
        });
        return mapper;
    }
}
