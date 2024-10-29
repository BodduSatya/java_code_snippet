package com.javamonk;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// Define the container annotation
@Retention(RetentionPolicy.RUNTIME)
@interface Schedules {
    Schedule[] value();
}

// Define the repeatable annotation
@Repeatable(Schedules.class)
@Retention(RetentionPolicy.RUNTIME)
@interface Schedule {
    String day();
    String time();
}


class Meeting {

    @Schedule(day = "Monday", time = "10:00 AM")
    @Schedule(day = "Wednesday", time = "2:00 PM")
    public void teamMeeting() {
        // Method implementation
    }
}


public class RepeatableAnnotations {
    public static void main(String[] args) throws NoSuchMethodException {
        Method method = Meeting.class.getMethod("teamMeeting");

        // Access repeatable annotations
        Schedule[] schedules = method.getAnnotationsByType(Schedule.class);

        for (Schedule schedule : schedules) {
            System.out.println("Day: " + schedule.day() + ", Time: " + schedule.time());
        }
    }
}
