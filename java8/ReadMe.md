Here’s a concise list of the main features introduced in Java 8:

1. **Lambda Expressions**: 
    Introduces a clear and concise way to represent a single abstract method interface using an expression.


2. **Functional Interfaces**: 
    New interfaces that only have one abstract method, annotated with `@FunctionalInterface`.


3. **Stream API**:
    Provides a powerful tool for processing collections of objects in a functional manner.


4. **Default & Static Methods in interface**: 
    Allows the addition of new methods to interfaces without breaking existing implementations.


| **Method Type**   | **Purpose**                                                                 | **Override**                                                                            |
|-------------------|-----------------------------------------------------------------------------|-----------------------------------------------------------------------------------------|
| **Static Methods**| Good for providing utility methods, for example null checking i.e whose difinition will never change. | Interface static methods helps us in providing security by not allowing implementation classes to override them.|
| **Default Methods**| Allow adding new methods to interfaces without breaking existing implementations, with the ability to provide a default implementation. | Can be overridden by implementing classes to provide a specific behavior.               |
    

5. **Optional Class**: Helps prevent `NullPointerExceptions` by providing a container object which may or may not contain a non-null value.


6. **Date and Time API**: Introduces a new, comprehensive API for date and time manipulation (`java.time` package).


7. **Nashorn JavaScript Engine**: A new, lightweight JavaScript engine integrated into the Java Virtual Machine (JVM).


8. **Method References**: Enables referring to methods or constructors directly using their names.


9. **CompletableFuture and Concurrency Enhancements**: Simplifies asynchronous programming by providing more options for handling concurrent tasks.


10. **Type Annotations**: Extends the capability of annotations to be used in more places, such as type uses.


11. **Base64 Encoding and Decoding**: Provides a new utility for encoding and decoding Base64.


12. **Parallel Array Sorting**: Enhances performance for large arrays by utilizing parallel sorting.


13. **Collectors**: A new utility in the Stream API for accumulating elements into collections and summarizing results.


14. **Stamps and Clock API**: A new set of classes for better handling of time and timestamps.


15. **Unsigned Arithmetic Support**: New utility methods for performing unsigned arithmetic operations.


16. **Repeating Annotations**: Allows the same annotation to be applied multiple times to a declaration.


17. **Enhanced Method Parameter Reflection**: Improved ability to obtain parameter names and information via reflection.


18. **StringJoiner**: A new utility class for constructing sequences of characters separated by delimiters.


19. **Map Enhancements**: Several new methods added to the `Map` interface, such as `forEach`, `compute`, `merge`, etc.


20. **Process API Updates**: Enhancements to process management and monitoring.


These features collectively enhance the language's capability to support functional programming, concurrency, and ease of use in various tasks like date-time manipulation and collection processing.


The Java 8 Stream API is a powerful feature for processing collections of data in a functional-style approach. It simplifies data manipulation by allowing developers to perform operations like filtering, mapping, and reducing. Here's a quick overview of the key concepts and operations:

### 1. **Creating a Stream**
Streams can be created from various data sources such as collections, arrays, or files.

```java
List<String> names = Arrays.asList("John", "Jane", "Tom", "Jerry");
Stream<String> stream = names.stream(); // Creating stream from a list
```

### 2. **Intermediate Operations**
These are the operations that transform a stream into another stream. They are lazy, meaning the operations are not performed until a terminal operation is invoked.

- **`filter()`**: Filters elements based on a condition.
  ```java
  List<String> filteredNames = names.stream()
      .filter(name -> name.startsWith("J"))
      .collect(Collectors.toList());
  ```

- **`map()`**: Transforms each element in the stream.
  ```java
  List<String> upperCaseNames = names.stream()
      .map(String::toUpperCase)
      .collect(Collectors.toList());
  ```

- **`sorted()`**: Sorts the elements.
  ```java
  List<String> sortedNames = names.stream()
      .sorted()
      .collect(Collectors.toList());
  ```

### 3. **Terminal Operations**
These are operations that terminate the stream and produce a result.

- **`collect()`**: Collects the stream into a collection or other data structure.
  ```java
  List<String> collectedNames = names.stream()
      .filter(name -> name.length() > 3)
      .collect(Collectors.toList());
  ```

- **`forEach()`**: Performs an action for each element.
  ```java
  names.stream()
      .forEach(System.out::println);
  ```

- **`reduce()`**: Performs a reduction on the elements of the stream.
  ```java
  Optional<String> concatenatedNames = names.stream()
      .reduce((name1, name2) -> name1 + ", " + name2);
  ```

- **`count()`**: Counts the number of elements in the stream.
  ```java
  long count = names.stream()
      .filter(name -> name.startsWith("J"))
      .count();
  ```

### 4. **Parallel Streams**
Streams can be made parallel to perform operations concurrently.

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
int sum = numbers.parallelStream()
    .reduce(0, Integer::sum);
```

### Example: Processing a List of Objects

```java
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
}

List<Person> people = Arrays.asList(
    new Person("John", 30),
    new Person("Jane", 25),
    new Person("Tom", 40)
);

// Find people older than 30 and collect their names
List<String> result = people.stream()
    .filter(person -> person.getAge() > 30)
    .map(Person::getName)
    .collect(Collectors.toList());
```

The Java 8 Stream API provides a clean and efficient way to work with collections and process data in a declarative manner.

In Java 8's Stream API, the `reduce()` method is used to **reduce** the elements of a stream to a single value by repeatedly applying a binary operation (a function that takes two arguments and returns a single result). This operation is known as a **reduction**.

There are three forms of the `reduce()` method:

### 1. **Without Identity**
This form of `reduce()` takes a **BinaryOperator** and reduces the elements without providing an initial value (identity). Since there is no initial value, the result is returned as an `Optional<T>`, as the stream may be empty.

**Syntax:**
```java
Optional<T> reduce(BinaryOperator<T> accumulator)
```

**Example:**
Reducing a list of integers by summing all the elements:
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

Optional<Integer> sum = numbers.stream()
    .reduce((a, b) -> a + b);

sum.ifPresent(System.out::println);  // Output: 15
```
In this case:
- `a` and `b` are two elements from the stream.
- The operation `a + b` is applied repeatedly to all the elements, eventually reducing the list to a single value (15).

If the stream is empty, `Optional.empty()` is returned.

### 2. **With Identity**
This form of `reduce()` provides an **identity** value, which acts as a starting point or a default value when the stream is empty. The identity must be neutral for the operation (i.e., when combined with any element, it does not change the result).

**Syntax:**
```java
T reduce(T identity, BinaryOperator<T> accumulator)
```

**Example:**
Summing a list of integers with an identity of 0:
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

int sum = numbers.stream()
    .reduce(0, (a, b) -> a + b);

System.out.println(sum);  // Output: 15
```
In this case:
- The identity is `0`, so the summing starts from 0.
- The reduction proceeds by summing all the elements of the stream.

If the stream is empty, the identity value (in this case, 0) is returned as the result.

### 3. **With Identity and Combiner (Parallel Streams)**
This form of `reduce()` is used for parallel processing. It takes three parameters: an identity value, a binary operator (accumulator), and a combiner. The **combiner** is used to combine partial results produced by multiple threads during parallel processing.

**Syntax:**
```java
<U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner)
```

**Example:**
Concatenating a list of strings:
```java
List<String> names = Arrays.asList("John", "Jane", "Tom", "Jerry");

String result = names.parallelStream()
    .reduce("", (partialString, element) -> partialString + element, (partialString1, partialString2) -> partialString1 + partialString2);

System.out.println(result);  // Output: JohnJaneTomJerry
```
In this case:
- The identity is an empty string `""`.
- The accumulator function concatenates each element with the partial result.
- The combiner function is used to combine the results from different threads when processing in parallel.

### Detailed Breakdown of Terms:
- **Identity**: The starting value for the reduction. For example, in sum operations, 0 is the identity, and in multiplication operations, 1 is the identity.
- **Accumulator**: A function that takes two values (the current partial result and the next element from the stream) and returns a new partial result.
- **Combiner**: A function used to combine partial results when the stream is processed in parallel.

### Example: Finding the Maximum Element in a Stream
```java
List<Integer> numbers = Arrays.asList(5, 10, 2, 8);

int max = numbers.stream()
    .reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);

System.out.println(max);  // Output: 10
```

In this example:
- The identity is `Integer.MIN_VALUE` (the smallest possible integer value).
- The accumulator compares two elements and keeps the larger one.

### Summary
- `reduce()` combines elements in a stream into a single result using a binary operation.
- It comes in three variants: without identity (returns `Optional<T>`), with identity (returns `T`), and with identity and combiner for parallel streams.
- Common use cases include summing, finding maximum/minimum, concatenating strings, and multiplying elements.