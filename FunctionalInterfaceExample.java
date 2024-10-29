import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        Consumer<String> printer = System.out::println;
        printer.accept("Hello, world!");
        List<String> s = Arrays.asList("satya","narayana","satya");
        Set<String> collect = s.stream().collect(Collectors.toSet());
        System.out.println("collect = " + collect);
    }


}*/


interface MyInterface {
    default void myDefaultMethod() {
        System.out.println("Default method in MyInterface");
    }
}

class FunctionalInterfaceExample implements MyInterface {
    // You can choose to override the default method, but it's not mandatory.

//    public void someMethod() {
//        // Calling the default method from within the class
//        myDefaultMethod();
//    }

   /* public static void main(String[] args) {
        FunctionalInterfaceExample myObject = new FunctionalInterfaceExample();
        myObject.myDefaultMethod(); // This will call the default method

        Stream.of("a","b","c");
        list.stream()
    }*/

    public static void main(String[] args) {
//        StringJoiner joiner = new StringJoiner(", ", "[", "]");
//
//        // Add elements to the StringJoiner
//        joiner.add("Apple");
//        joiner.add("Banana");
//        joiner.add("Orange");
//
//        // Convert the StringJoiner to a String
//        String result = joiner.toString();
//
//        // Print the result
//        System.out.println(result);

        String s1 = "satya";
        String s2 = "satya";
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
    }
}

