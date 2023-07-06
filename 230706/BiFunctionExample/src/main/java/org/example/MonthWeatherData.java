package org.example;

import java.time.LocalDate;
import java.util.Map;

public class MonthWeatherData {
    private Map<LocalDate, Map<Object, Object>> weatherData;

    public MonthWeatherData(Map<LocalDate, Map<Object, Object>> weatherData) {
        this.weatherData = weatherData;
    }

    public Map<LocalDate, Map<Object, Object>> getWeatherData() {
        return weatherData;
    }
}
