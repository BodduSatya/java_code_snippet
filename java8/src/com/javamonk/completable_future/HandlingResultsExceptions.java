package com.javamonk.completable_future;

import java.util.concurrent.CompletableFuture;

public class HandlingResultsExceptions {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> {
            // Simulate a task that might fail
            if (Math.random() > 0.5) {
                throw new RuntimeException("Failed");
            }
            return "Success";
        }).thenApply(result -> {
            System.out.println("Result: " + result);
            return result;
        }).exceptionally(ex -> {
            System.out.println("Exception: " + ex.getMessage());
            return null;
        }).join();  // Waits for the completion of the future

    }
}
