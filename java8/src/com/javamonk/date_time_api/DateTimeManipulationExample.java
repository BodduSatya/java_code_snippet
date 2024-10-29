package com.javamonk.date_time_api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DateTimeManipulationExample {

    public static void main(String[] args) {
        // Add days to a date
        LocalDate today = LocalDate.now();
        LocalDate nextWeek = today.plusDays(7);
        System.out.println("Date next week: " + nextWeek);

        // Subtract months from a date
        LocalDate lastMonth = today.minusMonths(1);
        System.out.println("Date last month: " + lastMonth);

        // Add hours to a date-time
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime futureTime = now.plusHours(5);
        System.out.println("Time in 5 hours: " + futureTime);

        // Difference between two dates
        long daysBetween = ChronoUnit.DAYS.between(lastMonth, today);
        System.out.println("Days between dates: " + daysBetween);
    }
}

