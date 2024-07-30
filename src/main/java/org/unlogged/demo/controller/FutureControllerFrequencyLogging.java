package org.unlogged.demo.controller;
import io.unlogged.UnloggedClass;
import io.unlogged.UnloggedMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.unlogged.demo.service.FutureService;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@UnloggedClass(counter = "3")
public class FutureControllerFrequencyLogging {

    @Autowired
    public FutureService futureService;

    @UnloggedMethod(counter="1")
    public String getFutureResult(String s1) throws ExecutionException, InterruptedException {
        CompletableFuture<String> result = futureService.doSomething();
        return result.get();
    }

    public String getFutureResultOptional(String s1) throws ExecutionException, InterruptedException {
        Optional<String> result = futureService.doSomethingOptional(s1);
        return result.get();
    }
}
