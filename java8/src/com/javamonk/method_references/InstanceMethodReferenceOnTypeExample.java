package com.javamonk.method_references;

import java.util.Arrays;
import java.util.List;

public class InstanceMethodReferenceOnTypeExample {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("cherry","banana","apple");

        // Using a method reference to sort a list
        strings.sort(String::compareToIgnoreCase);

        System.out.println("Sorted list: " + strings);  // Output: [apple, banana, cherry]
    }
}
