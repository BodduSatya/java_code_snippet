package com.javamonk.stream_api;

import java.util.*;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        List<Integer> orderList = Arrays.asList(5,8,9,10,2);

        /*names.stream()
                .filter(name -> name.startsWith("C"))
                .forEach(System.out::println); // Outputs "Charlie"*/

        // INTERMEDIATE OPERATIONS :: filter, map, sorted
        // TERMINAL OPERATIONS :: reduce(), collect(), forEach(), count(), anyMatch(), allMatch(), noneMatch()
        //                        findFirst(), findAny(), max() and min()

        List<String> result = names.stream()
                .filter(name -> name.startsWith("D"))
                .map(name -> name.toUpperCase())
                .collect(Collectors.toList());

        System.out.println(result);


        Optional<Integer> max = orderList.stream().reduce((a, b) -> a > b ? a : b);
        max.ifPresent(System.out::println);

        Integer max2 = orderList.stream().reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);
        System.out.println(max2);

        /*
          Identity:     The starting value for the reduction. For example, in sum operations,
                        0 is the identity, and in multiplication operations, 1 is the identity.

          Accumulator:  A function that takes two values (the current partial result and the
                        next element from the stream) and returns a new partial result.

          Combiner:     A function used to combine partial results when the stream is processed in parallel.
         */
        Integer max3 = orderList.parallelStream().reduce(
                Integer.MIN_VALUE, // identity
                (a, b) -> a > b ? a : b,  // accumulator function
                (d, e) -> d > e ? d : e   // combiner function
        );
        System.out.println(max3);

        List<Emp> Emps = new ArrayList<>();
        Emps.add(new Emp("A",1000d,35));
        Emps.add(new Emp("b",4000d,33));
        Emps.add(new Emp("c",5000d,40));

        Optional<Emp> e = Emps.stream().reduce((e1, e2)-> e1.salary > e2.salary ? e1 : e2);
        e.ifPresent(Emp -> System.out.println(Emp.name));

        Optional<Emp> e1 = Emps.stream()
                .max(Comparator.comparingDouble(Emp -> Emp.salary));
        e1.ifPresent(Emp -> System.out.println(Emp.name));

    }
}

class Emp{
    String name;
    Double salary;
    int age;

    public Emp(String name, Double salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

}
