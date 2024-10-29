package com.javamonk.functional_interfaces;

public class Test1 {
    public static void main(String[] args) {

        // Using lambda expression
        Calculator add = (x, y) -> x + y;
        Calculator multiply = (x, y) -> x * y;

        System.out.println(add.calculate(3, 4)); // Outputs 7
        System.out.println(multiply.calculate(3, 4)); // Outputs 12
    }
}

@FunctionalInterface
interface Calculator {
    int calculate(int x, int y);
}


