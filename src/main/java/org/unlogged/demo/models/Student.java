package org.unlogged.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Student")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
public class Student implements Serializable {

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.gender = Gender.MALE;
        this.grade = 61;
    }

    public enum Gender {
        MALE, FEMALE;

        public static Gender getFromString(String value) {
            for (Gender gender1 : Gender.values()) {
                if (gender1.toString().toLowerCase().equals(value.toLowerCase())) {
                    return gender1;
                }
            }
            return null;
        }
    }

    private String id;
    private String name;
    private Gender gender;
    private int grade;
}