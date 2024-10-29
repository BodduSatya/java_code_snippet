package com.javamonk.method_references;

import java.util.function.Supplier;

public class ConstructorReferenceExample {

    // Class with a constructor
    static class Person {
        String name;

        Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{name='" + name + "'}";
        }
    }

    public static void main(String[] args) {
        // Using a constructor reference
        Supplier<Person> personSupplier = () -> new Person("John Doe");

        // Creating an instance using the method reference
        Person person = personSupplier.get();
        System.out.println(person);  // Output: Person{name='John Doe'}
    }
}

