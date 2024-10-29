package com.javamonk.lambda_expressions;

public class Test1 {
    public static void main(String[] args) {

        // Before Java 8
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Conventional Runnable.");
            }
        };
        runnable.run();



        // With Java 8
        Runnable runnableLambda = () -> System.out.println("Lambda Expression Runnable.");
        runnableLambda.run();
    }
}
