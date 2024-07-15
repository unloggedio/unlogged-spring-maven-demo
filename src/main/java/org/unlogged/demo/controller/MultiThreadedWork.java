package org.unlogged.demo.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiThreadedWork {

    public void executeTasksInParallel(int numberOfThreads, int wait_second) {
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);

        for (int i = 0; i < numberOfThreads; i++) {
            int taskNumber = i;
            executorService.submit(() -> performTask(taskNumber));
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(wait_second, TimeUnit.SECONDS)) {
                // force shut
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    private void performTask(int taskNumber) {
        System.out.println("Task " + taskNumber + " is running on thread " + Thread.currentThread().getName());
        try {
            // task execution on thread
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Task " + taskNumber + " completed on thread " + Thread.currentThread().getName());
    }
}
