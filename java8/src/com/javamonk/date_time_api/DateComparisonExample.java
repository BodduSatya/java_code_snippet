package com.javamonk.date_time_api;

import java.time.LocalDate;

public class DateComparisonExample {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate futureDate = today.plusDays(10);

        if (futureDate.isAfter(today)) {
            System.out.println("The future date is after today.");
        } else if (futureDate.isBefore(today)) {
            System.out.println("The future date is before today.");
        } else {
            System.out.println("The future date is today.");
        }
    }
}

