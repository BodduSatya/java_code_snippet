package com.javamonk.date_time_api;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeZoneExample {

    public static void main(String[] args) {
        // Current date and time in different time zones
        ZonedDateTime tokyoTime = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        ZonedDateTime newYorkTime = ZonedDateTime.now(ZoneId.of("America/New_York"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");

        System.out.println("Tokyo time: " + tokyoTime.format(formatter));
        System.out.println("New York time: " + newYorkTime.format(formatter));
    }
}

