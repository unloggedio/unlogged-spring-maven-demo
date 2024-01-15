package org.unlogged.demo.service;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class FutureService {

    public CompletableFuture<String> doSomething() {
        CompletableFuture<String> stringCompletableFuture = new CompletableFuture<>();
        stringCompletableFuture.complete("yolo");
        return stringCompletableFuture;
    }

    public Optional<String> doSomethingOptional(String optional) {
        return Optional.of(optional);
    }
}
