package org.unlogged.demo;

import io.unlogged.Unlogged;
import jakarta.persistence.EntityManagerFactory;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.unlogged.demo.models.session.Department;
import org.unlogged.demo.models.session.DepartmentDTO;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "org.unlogged.demo")
@EnableTransactionManagement
//@EnableScheduling
public class UnloggedDemoApplication {
    @Unlogged(port = 12100)
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
