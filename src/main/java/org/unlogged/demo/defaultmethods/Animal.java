package org.unlogged.demo.defaultmethods;

import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

public interface Animal {

    default ResponseEntity<String> getDefaultMethod(String userId) {
        return ResponseEntity.ok("Cat");
    }

    default List<String> getDefaultMethodList() {
        return Arrays.asList("Dog", "Lion", "Elephant");
    }

    static String getStaticMethod() {
        return "Static Animal";
    }
}

