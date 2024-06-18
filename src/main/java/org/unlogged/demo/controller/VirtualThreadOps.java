package org.unlogged.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unlogged.demo.jspdemo.wfm.Models.Entities.User;
import org.unlogged.demo.jspdemo.wfm.Services.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping("/vts")
public class VirtualThreadOps {

    @Autowired
    private UserService userService;


    @RequestMapping("/add")
    public void insertUser(@RequestBody User user) throws InterruptedException, ExecutionException {
        ThreadFactory virtualThreadFactory = Thread.ofVirtual().name("insert-user").factory();
        ExecutorService executorService = Executors.newThreadPerTaskExecutor(virtualThreadFactory);

        executorService.submit(() -> userService.addUser(user));
    }

    @RequestMapping("/name")
    public User getByName(String name) throws InterruptedException, ExecutionException {
        ThreadFactory virtualThreadFactory = Thread.ofVirtual().name("get-user").factory();
        ExecutorService executorService = Executors.newThreadPerTaskExecutor(virtualThreadFactory);
        Callable<User> getUsers = () -> {
            return userService.getUser(name);
        };
        Future<User> userFuture = executorService.submit(getUsers);
        Thread.sleep(250);
        return userFuture.get();
    }

    @RequestMapping("/all")
    public List<User> findAll() throws InterruptedException, ExecutionException {
        ThreadFactory virtualThreadFactory = Thread.ofVirtual().name("get-all-users").factory();
        ExecutorService executorService = Executors.newThreadPerTaskExecutor(virtualThreadFactory);
        AtomicReference<List<User>> ref = new AtomicReference<>(new ArrayList<>());

        Callable<List<User>> getUsers = () -> {
            return userService.getAllUsers();
        };
        Future<List<User>> userFuture = executorService.submit(getUsers);
        Thread.sleep(250);
        return userFuture.get();
    }
}
