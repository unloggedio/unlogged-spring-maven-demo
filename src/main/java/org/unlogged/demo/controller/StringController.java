package org.unlogged.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StringController {

    @RequestMapping("/multiline")
    public String getMultilineString() {
        String multilineString = """
                This is a multiline string.
                It is being used to test jdk21
                """;
        return multilineString;
    }

    @RequestMapping("/varString/1")
    public String getVarString() {
        var testString = "VarString";
        return testString;
    }
}
