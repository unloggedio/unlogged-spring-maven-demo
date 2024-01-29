package org.unlogged.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.unlogged.demo.models.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {
}
