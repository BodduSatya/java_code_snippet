package com.javamonk.method_references;

import java.util.function.Consumer;

public class InstanceMethodReferenceExample {

    // Instance method to be referenced
    public void printMessage(String message) {
        System.out.println("Message: " + message);
    }

    public static void main(String[] args) {
        InstanceMethodReferenceExample example = new InstanceMethodReferenceExample();

        // Using a method reference on a specific instance
        Consumer<String> messagePrinter = example::printMessage;

        // Applying the method reference
        messagePrinter.accept("Hello, World!");  // Output: Message: Hello, World!

    }
}

