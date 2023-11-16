package org.example;

import java.time.LocalDate;

public class WeatherInfoKeyUtils {
    public static String key(LocalDate date, String locationCode, WeatherSubKeySuffix suffix) {
        return "weather:" + locationCode + ":" + date + ":" + suffix;
    }
}
