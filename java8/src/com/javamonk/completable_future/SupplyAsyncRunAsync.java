package com.javamonk.completable_future;

import java.util.concurrent.CompletableFuture;

public class SupplyAsyncRunAsync {
    public static void main(String[] args) {

        /*
        * Use supplyAsync when your task needs to return a value.
        *   Eg: Fetching data, performing a computation
        * Use runAsync when your task does not return a value and only performs an action.
        *   Eg: Logging, sending a notification
         * */

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            // Simulate a long-running task
            return 42;  // The task produces a result
        });

        // You can use thenApply or thenAccept to process the result
        future.thenAccept(result -> System.out.println("Result: " + result));


        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            // Simulate a long-running task
            System.out.println("Task is running");
            // The task does not produce a result
        });

        // You can use thenRun or thenAccept to continue after the task finishes
        future2.thenRun(() -> System.out.println("Task completed"));


    }
}
