package com.javamonk.method_references;

import java.util.List;
import java.util.function.Function;
import java.util.Arrays;

public class ArrayReferenceExample {

    public static void main(String[] args) {
        // Create an array of strings
        String[] strings = {"one", "two", "three"};

        // Using method reference to convert array to list
        Function<String[], List<String>> arrayToList = Arrays::asList;

        // Converting array to list
        List<String> stringList = arrayToList.apply(strings);
        System.out.println("List: " + stringList);  // Output: [one, two, three]
    }
}
