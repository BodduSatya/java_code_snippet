package com.javamonk.date_time_api;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatExample {

    public static void main(String[] args) {
        // Parse a date from a string
        String dateStr = "2024-08-15";
        LocalDate date = LocalDate.parse(dateStr);
        System.out.println("Parsed date: " + date);

        // Parse a date with formatter from a string
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dateStr2 = "04/04/1984";
        LocalDate date2 = LocalDate.parse(dateStr2, formatter1);
        System.out.println("Parsed date2: " + date2);

        // Format a date to a string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = date.format(formatter);
        System.out.println("Formatted date: " + formattedDate);
    }
}

