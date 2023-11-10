package org.unlogged.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.unlogged.demo.models.Student;
import org.unlogged.demo.service.StudentService;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("all")
    public Collection<Student> getAllStudents() {
        return studentService.findAll();
    }


    @RequestMapping("{id}")
    public Optional<Student> getById(String id) {
        return studentService.getStudent(id);
    }

    @PostMapping(path = "")
    public boolean createStudent(Student student) {
        return studentService.createStudent(student);
    }

    @PostMapping
    public boolean updateStudent(Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping
    public boolean deleteStudent(String id) {
        return studentService.deleteStudent(id);
    }
}
