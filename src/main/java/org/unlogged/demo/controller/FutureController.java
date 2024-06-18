package org.unlogged.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unlogged.demo.service.FutureService;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/future")
public class FutureController {

    @Autowired
    public FutureService futureService;

    @RequestMapping("/futureResult")
    public String getFutureResult(String s1) throws ExecutionException, InterruptedException {
        CompletableFuture<String> result = futureService.doSomething();
        return result.get();
    }

    @RequestMapping("/futureResultOptional")
    public String getFutureResultOptional(String s1) throws ExecutionException, InterruptedException {
        Optional<String> result = futureService.doSomethingOptional(s1);
        return result.get();
    }
}
