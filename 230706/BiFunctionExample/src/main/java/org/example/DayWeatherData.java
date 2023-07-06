package org.example;

import java.time.LocalDate;
import java.util.Map;

public class DayWeatherData {
    private Map<LocalDate, Map<Object, Object>> weatherData;

    public DayWeatherData(Map<LocalDate, Map<Object, Object>> weatherData) {
        this.weatherData = weatherData;
    }

    public Map<LocalDate, Map<Object, Object>> getWeatherData() {
        return weatherData;
    }
}
