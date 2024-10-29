package com.javamonk.completable_future;

import java.util.concurrent.CompletableFuture;

public class CombiningMultipleCompletableFutureInstances {
    public static void main(String[] args) {
        /*CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "World");

        future1.thenCombine(future2, (result1, result2) -> result1 + " " + result2)
                .thenAccept(System.out::println);*/


        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 5)
                .thenCompose(result -> CompletableFuture.supplyAsync(() -> result * 2))
                .thenApply(result -> result + 1);

        future.thenAccept(System.out::println);  // Output will be 11

    }
}
