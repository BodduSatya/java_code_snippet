package com.javamonk.concurren_hashmap;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();

        // Adding elements
        concurrentMap.put("One", 1);
        concurrentMap.put("Two", 2);
        concurrentMap.put("Three", 3);

        // forEach to iterate over the map
        concurrentMap.forEach((key, value) -> System.out.println(key + " : " + value));

        // compute method
        concurrentMap.compute("Two", (key, value) -> value == null ? 0 : value + 2);
        System.out.println("After compute: " + concurrentMap);

        // computeIfAbsent method
        concurrentMap.computeIfAbsent("Four", key -> 4);
        System.out.println("After computeIfAbsent: " + concurrentMap);

        // computeIfPresent method
        concurrentMap.computeIfPresent("Three", (key, value) -> value + 3);
        System.out.println("After computeIfPresent: " + concurrentMap);

        // merge method
        concurrentMap.merge("One", 5, Integer::sum);
        System.out.println("After merge: " + concurrentMap);

        // search method
        Integer result = concurrentMap.search(1, (key, value) -> {
            if ("Two".equals(key)) {
                return value;
            }
            return null;
        });
        System.out.println("Search result for key 'Two': " + result);

        // reduce method
        int sum = concurrentMap.reduceValues(1, Integer::sum);
        System.out.println("Sum of values: " + sum);
    }
}

