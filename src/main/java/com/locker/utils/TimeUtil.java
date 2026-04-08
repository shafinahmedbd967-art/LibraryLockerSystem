package com.locker.utils;

import java.time.LocalTime;

public class TimeUtil {

    public static boolean isWithinAllowedTime() {
        LocalTime now = LocalTime.now();
        LocalTime start = LocalTime.of(8, 0);
        LocalTime end = LocalTime.of(20, 0);

        return now.isAfter(start) && now.isBefore(end);
    }
}