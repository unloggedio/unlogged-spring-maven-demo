package org.unlogged.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RestController
public class PredicateDemoController {

    private final List<String> sampleList = List.of("apple", "banana", "cherry", "date", "elderberry");

    @GetMapping("/isEqual")
    public List<String> isEqual(@RequestParam String target) {
        Predicate<String> isEqual = Predicate.isEqual(target);

        return sampleList.stream()
                .filter(isEqual)
                .collect(Collectors.toList());
    }

    @GetMapping("/and")
    public List<String> and(@RequestParam String target) {
        Predicate<String> isEqual = Predicate.isEqual(target);
        Predicate<String> lengthGreaterThanFive = s -> s.length() > 5;

        Predicate<String> combinedPredicate = isEqual.and(lengthGreaterThanFive);

        return sampleList.stream()
                .filter(combinedPredicate)
                .collect(Collectors.toList());
    }

    @GetMapping("/or")
    public List<String> or(@RequestParam String target) {
        Predicate<String> isEqual = Predicate.isEqual(target);
        Predicate<String> lengthGreaterThanFive = s -> s.length() > 5;

        Predicate<String> combinedPredicate = isEqual.or(lengthGreaterThanFive);

        return sampleList.stream()
                .filter(combinedPredicate)
                .collect(Collectors.toList());
    }

    @GetMapping("/negate")
    public List<String> negate(@RequestParam String target) {
        Predicate<String> isEqual = Predicate.isEqual(target);
        Predicate<String> negatePredicate = isEqual.negate();

        return sampleList.stream()
                .filter(negatePredicate)
                .collect(Collectors.toList());
    }

    @GetMapping("/not")
    public List<String> not(@RequestParam String target) {
        Predicate<String> isEqual = Predicate.isEqual(target);
        Predicate<String> notPredicate = Predicate.not(isEqual);

        return sampleList.stream()
                .filter(notPredicate)
                .collect(Collectors.toList());
    }
}

