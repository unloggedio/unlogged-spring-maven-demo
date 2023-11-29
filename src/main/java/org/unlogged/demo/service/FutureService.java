package org.unlogged.demo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class FutureService {

    public CompletableFuture<String> doSomething() {
        CompletableFuture<String> stringCompletableFuture = new CompletableFuture<>();
        stringCompletableFuture.complete("yolo");
        return stringCompletableFuture;
    }
}
