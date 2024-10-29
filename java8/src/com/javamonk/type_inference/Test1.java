package com.javamonk.type_inference;

import java.util.*;
import java.util.function.Function;

public class Test1 {
    public static void main(String[] args) {

        /*TODO 1. Type Inference with Lambda Expressions*/

        // Before Java 8:
        Function<String, Integer> stringToLength = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };

        // Java 8 and beyond:
        Function<String, Integer> stringToLength2 = s -> s.length();

        /*TODO 2. Diamond Operator with Generics*/

        //Before java8
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        //Java 8 and beyond:
        Map<String, List<String>> map2 = new HashMap<>();

        /*TODO 3. Type Inference in Method References*/

        // Before Java 8:
        Function<String, Integer> stringToLength3 = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };

        // Java 8 and beyond:
        Function<String, Integer> stringToLength4 = String::length;

        /*TODO 4. Inferred Types in Generic Methods*/

        //Before Java 8:
        List<String> stringList = asList("A", "B", "C");
        List<Integer> intList = asList(1, 2, 3, 4, 5);

        // Print lists
        System.out.println("String List: " + stringList);
        System.out.println("Integer List: " + intList);

        // Java8 and Beyond
        List<String> list = Arrays.asList("A", "B", "C");


        /*Todo 5. Improved Type Inference in For-Each Loops*/
        //Before java8
        for (String s : list) {
            System.out.println(s);
        }

        //Java8 and Beyond
        list.forEach(System.out::println);

    }

    public static <T> List<T> asList(T... a) {
        List<T> list = new ArrayList<>(a.length);
        for (T element : a) {
            list.add(element);
        }
        return list;
    }
}
