package com.javamonk;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class CollectorsForStreams {
    public static void main(String[] args) {


        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> uppercaseNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(uppercaseNames); // Outputs [ALICE, BOB, CHARLIE]

    }
}
