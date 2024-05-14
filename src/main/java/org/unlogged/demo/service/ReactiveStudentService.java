//package org.unlogged.demo.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.unlogged.demo.models.Student;
//import org.unlogged.demo.repository.StudentRepository;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ReactiveStudentService {
//
//    @Autowired
//    StudentRepository studentRepository;
//
//    public Optional<Student> getStudent(String id) {
//        return studentRepository.findById(id);
//    }
//
//    public List<Student> findAll() {
//        List<Student> allStudents = new ArrayList<>();
//        for (Student student : studentRepository.findAll()) {
//            allStudents.add(student);
//        }
//
//        return allStudents;
//    }
//
//    public boolean updateStudent(Student student) {
//        studentRepository.save(student);
//        return true;
//    }
//
//    public boolean updateAllStudent(Collection<Student> student) {
//        studentRepository.saveAll(student);
//        return true;
//    }
//
//    public boolean createStudent(Student student) {
//        studentRepository.save(student);
//        return true;
//    }
//
//    public boolean deleteStudent(String id) {
//        studentRepository.deleteById(id);
//        return true;
//    }
//}
