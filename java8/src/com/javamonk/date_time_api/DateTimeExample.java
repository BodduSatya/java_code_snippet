package com.javamonk.date_time_api;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class DateTimeExample {

    public static void main(String[] args) {
        // Current date
        LocalDate today = LocalDate.now();
        System.out.println("Current date: " + today);

        // Current time
        LocalTime now = LocalTime.now();
        System.out.println("Current time: " + now);

        // Current date and time
        LocalDateTime dateTimeNow = LocalDateTime.now();
        System.out.println("Current date and time: " + dateTimeNow);

        // Current date and time with timezone
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("Current date and time with timezone: " + zonedDateTime);
    }
}

