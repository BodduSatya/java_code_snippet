package com.javamonk.completable_future;

import java.util.concurrent.CompletableFuture;

public class ManualCompletion {
    public static void main(String[] args) {
        CompletableFuture<String> future = new CompletableFuture<>();
        // Complete manually
        future.complete("Manually Completed");
        future.thenAccept(System.out::println);
    }
}
