package com.javamonk.completable_future;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String[] args) {
        // Create a CompletableFuture using supplyAsync
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            // Simulate a long-running task
            try {
                System.out.println("SupplyAsync");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello, World!";
        });

        // Block and get the result (for demonstration purposes)
        try {
            String result = future.get();  // Blocks until the result is available
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

