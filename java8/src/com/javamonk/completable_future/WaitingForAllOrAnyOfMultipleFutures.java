package com.javamonk.completable_future;

import java.util.concurrent.CompletableFuture;

public class WaitingForAllOrAnyOfMultipleFutures {
    public static void main(String[] args) {
        CompletableFuture<Void> allOf = CompletableFuture.allOf(
                CompletableFuture.supplyAsync(() -> "Task 1"),
                CompletableFuture.supplyAsync(() -> "Task 2")
        );

        allOf.thenRun(() -> System.out.println("All tasks completed"));

        CompletableFuture<Object> anyOf = CompletableFuture.anyOf(
                CompletableFuture.supplyAsync(() -> "Task 1"),
                CompletableFuture.supplyAsync(() -> "Task 2")
        );

        anyOf.thenAccept(result -> System.out.println("First completed task: " + result));

    }
}
