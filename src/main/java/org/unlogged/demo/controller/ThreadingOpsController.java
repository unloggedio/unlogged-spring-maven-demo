package org.unlogged.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping("/threads")
public class ThreadingOpsController {

    private List<Callable<String>> getListofCallables() {
        Callable<String> callableTask = () -> {
            return "E";
        };
        List<Callable<String>> callableTasks = new ArrayList<>();
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);
        return callableTasks;
    }

    @RequestMapping("/es1")
    public List<String> executorServiceCallablesAll() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<String>> futures = executor.invokeAll(getListofCallables());
        return futures.stream().map(future -> {
            try {
                return future.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }).toList();
    }

    @RequestMapping("/es2")
    public String executorServiceCallablesAny() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Collection<Callable<String>> listOfCallables = getListofCallables();
        return executor.invokeAny(listOfCallables);
    }

    @RequestMapping("/es3")
    public String executorServiceRunnable() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        AtomicReference<String> resultString = new AtomicReference<>("");
        Runnable runnableTask1 = () -> {
            try {
                resultString.set(resultString.get() + "#R1");
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        executor.execute(runnableTask1);
        Thread.sleep(125);
        return resultString.get();
    }

    @RequestMapping("/scheduled1")
    public String scheduledThread() {
        ScheduledExecutorService executorService = Executors
                .newSingleThreadScheduledExecutor();

        Future<String> resultFuture =
                executorService.schedule(getListofCallables().get(0), 1, TimeUnit.SECONDS);
        try {
            return resultFuture.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/scheduled2")
    public String scheduledThreadFixedRate() throws InterruptedException {
        ScheduledExecutorService executorService = Executors
                .newSingleThreadScheduledExecutor();

        AtomicReference<String> resultString = new AtomicReference<>("");
        Runnable runnableTask1 = () -> {
            try {
                resultString.set(resultString.get() + "#R1");
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        executorService.scheduleAtFixedRate(runnableTask1, 100, 100, TimeUnit.SECONDS);
        Thread.sleep(500);
        return resultString.get();
    }

    @RequestMapping("/scheduled3")
    public String scheduledThreadFixedDelay() throws ExecutionException, InterruptedException {
        ScheduledExecutorService executorService = Executors
                .newSingleThreadScheduledExecutor();

        AtomicReference<String> resultString = new AtomicReference<>("");
        Runnable runnableTask1 = () -> {
            try {
                resultString.set(resultString.get() + "#R1");
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        executorService.scheduleWithFixedDelay(runnableTask1, 100, 100, TimeUnit.MILLISECONDS);
        Thread.sleep(250);
        return resultString.get();
    }
}
