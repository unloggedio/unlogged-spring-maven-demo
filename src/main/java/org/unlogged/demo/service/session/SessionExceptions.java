package org.unlogged.demo.service.session;

import jakarta.persistence.EntityManagerFactory;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.unlogged.demo.models.session.*;
import org.unlogged.demo.repository.DepartmentRepository;

import static java.util.stream.Collectors.toList;

@Service
public class SessionExceptions {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DepartmentRepository deptRepo;

    //LazyLoad Exception
    public Departments getAllDepartments() {
        Departments departments = new Departments();
        departments.setDepartments(deptRepo.findAll().stream().map(
                        dept -> modelMapper.map(dept, DepartmentDTO.class))
                .collect(toList()));
        return departments;
    }

    //Infinite Recursion Trace
    @Transactional
    public Departments getAllDepartmentsTransactional() {
        Departments departments = new Departments();
        departments.setDepartments(deptRepo.findAll().stream().map(
                        dept -> modelMapper.map(dept, DepartmentDTO.class))
                .collect(toList()));
        return departments;
    }
}
