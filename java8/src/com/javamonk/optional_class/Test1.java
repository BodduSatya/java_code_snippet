package com.javamonk.optional_class;

import java.util.Optional;

public class Test1 {
    public static void main(String[] args) {
        // Example 1: Creating an Optional with a non-null value
        Optional<String> optionalWithValue = Optional.of("Hello, World!");
        System.out.println("Value: " + optionalWithValue.get());  // Output: Hello, World!

        // Example 2: Creating an Optional with a null value (use Optional.ofNullable)
        Optional<String> optionalWithNull = Optional.ofNullable(null);
        System.out.println("Is present: " + optionalWithNull.isPresent());  // Output: false

        // Example 3: Using orElse to provide a default value
        String value = optionalWithNull.orElse("Default Value");
        System.out.println("Value: " + value);  // Output: Default Value

        // Example 4: Using ifPresent to execute code if the value is present
        optionalWithValue.ifPresent(v -> System.out.println("Value is present: " + v));  // Output: Value is present: Hello, World!

        // Example 5: Using map to transform the value
        Optional<String> upperCaseValue = optionalWithValue.map(String::toUpperCase);
        System.out.println("Upper case value: " + upperCaseValue.get());  // Output: HELLO, WORLD!

        // Example 6: Using flatMap to chain multiple Optional operations
        Optional<String> result = optionalWithValue.flatMap(v -> Optional.of(v + "!!!"));
        System.out.println("Result: " + result.get());  // Output: Hello, World!!!!
    }
}
