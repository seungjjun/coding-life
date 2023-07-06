package org.example;

import java.util.Map;

public interface WeatherInfoRepository {
    Map<Object, Object> getWeatherInfo(String key);
}
