package com.javamonk;

import java.util.StringJoiner;

public class StringJoinerExample {
    public static void main(String[] args) {

        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        joiner.add("Alice").add("Bob").add("Charlie");
        System.out.println(joiner); // Outputs [Alice, Bob, Charlie]

    }
}
