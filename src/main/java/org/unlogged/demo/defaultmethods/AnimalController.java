package org.unlogged.demo.defaultmethods;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class AnimalController implements Animal {

    @GetMapping("/animal/mono")
    public ResponseEntity<String> getAnimal(String userId) {
        // Directly call the default method from the Animal interface
        return getDefaultMethod(userId);
    }

    @GetMapping("/animal/flux")
    public List<String> getAnimalList() {
        // Directly call the default method from the Animal interface
        return getDefaultMethodList();
    }

    @GetMapping("/animal/static")
    public String getStaticMethod() {
        // Call the static method from the Animal interface
        return Animal.getStaticMethod();
    }
}