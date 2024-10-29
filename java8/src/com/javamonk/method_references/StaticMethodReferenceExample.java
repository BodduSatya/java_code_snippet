package com.javamonk.method_references;

import java.util.function.Function;

public class StaticMethodReferenceExample {

    // Static method to be referenced
    public static int square(int x) {
        return x * x;
    }

    public static void main(String[] args) {
        // Using a method reference
        Function<Integer, Integer> squareFunction = StaticMethodReferenceExample::square;

        // Applying the method reference
        System.out.println("Square of 5: " + squareFunction.apply(5));  // Output: 25
    }
}

