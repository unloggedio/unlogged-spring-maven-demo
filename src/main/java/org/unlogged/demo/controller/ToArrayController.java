package org.unlogged.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.function.IntFunction;

@RestController
@RequestMapping("/collectionstoarray")
public class ToArrayController {

    @GetMapping("/default-toArray")
    public Object[] getDefaultToArray() {
        List<String> list = List.of("Apple", "Banana", "Cherry");
        return list.toArray();
    }

    @GetMapping("/generator-toArray")
    public String[] getGeneratorToArray() {
        List<String> list = List.of("Dog", "Elephant", "Frog");
        IntFunction<String[]> generator = String[]::new;
        return list.toArray(generator);
    }

    @GetMapping("/array-toArray")
    public String[] getArrayToArray() {
        List<String> list = List.of("Giraffe", "Hippo", "Iguana");
        String[] array = new String[list.size()];
        return list.toArray(array);
    }
}
