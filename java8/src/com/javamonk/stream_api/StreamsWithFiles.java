package com.javamonk.stream_api;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsWithFiles {
    public static void main(String[] args) {

        Path path = Paths.get("./resources/notes.txt");
        System.out.println("Current working directory: " + System.getProperty("user.dir"));

        // Read file lines as stream of strings
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(System.out::println); // Print each line to the console
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*// Read file lines as stream of strings, apply operation
        try (Stream<String> lines = Files.lines(path)) {
            lines.filter(line -> line.contains("a"))  // Filter lines containing a keyword
                    .forEach(System.out::println);              // Print each line
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*// Read all lines into a list
        try {
            List<String> lines = Files.readAllLines(path);
            lines.stream()
                    .filter(line -> line.length() > 2)  // Example filter: lines longer than 50 characters
                    .forEach(System.out::println);       // Print each line
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*// write to a file
        try (Stream<String> lines = Stream.of("Line 1", "Line 2", "Line 3")) {
            Files.write(Paths.get("./resources/output.txt"),
                    lines.collect(Collectors.toList()));  // Collect stream to list and write to file
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*// Append to a file
        try (Stream<String> lines = Stream.of("Append Line 1", "Append Line 2")) {
            Files.write(Paths.get("./resources/output.txt"),
                    (Iterable<String>)lines::iterator,
                    StandardOpenOption.APPEND,
                    StandardOpenOption.CREATE);  // Append and create file if it doesn't exist
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
