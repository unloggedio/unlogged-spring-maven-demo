package org.unlogged.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.unlogged.demo.service.FutureService;

import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;

public class Customer {

    @Inject
    Logger LOG;

    @Autowired
    public FutureService futureService;

    public Customer() {
        // This log will throw a NPE as LOG is not defined yet
        // LOG.info("The constructor is called");
    }

    @PostConstruct
    public void postConstructorMethod() {
        CompletableFuture<String> result = futureService.doSomething();
        // This will work fine since LOG is defined now
        LOG.info("The post constructor method is called");
    }
}
