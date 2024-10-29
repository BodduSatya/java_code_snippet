package com.javamonk;

import java.util.Arrays;

public class ParallelArraySorting {
    /*
    Java 8 provides a method to sort arrays in parallel using multiple threads,
    improving performance on large arrays.
    * */

    public static void main(String[] args) {
        int[] numbers = { 5, 2, 8, 3, 1, 9, 7 };
        Arrays.parallelSort(numbers);
        System.out.println(Arrays.toString(numbers)); // Outputs sorted array
    }
}
