package org.unlogged.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Student")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student implements Serializable {

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.gender = Gender.MALE;
        this.grade = 61;
    }

    public enum Gender {
        MALE, FEMALE
    }

    private String id;
    private String name;
    private Gender gender;
    private int grade;
}