package org.example;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class WeatherService {
    private final WeatherInfoRepository weatherInfoRepository;

    public WeatherService(WeatherInfoRepository weatherInfoRepository) {
        this.weatherInfoRepository = weatherInfoRepository;
    }

    public <T> T getWeatherData(List<LocalDate> dates, BiFunction<LocalDate, String, String> keyCreator, Function<Map<LocalDate, Map<Object, Object>>, T> resultCreator, String uniqueIdentifier) {
        Map<LocalDate, Map<Object, Object>> dateWithWeatherData = new HashMap<>();

        for (LocalDate date : dates) {
            Map<Object, Object> weatherData = weatherInfoRepository.getWeatherInfo(keyCreator.apply(date, uniqueIdentifier));
            dateWithWeatherData.put(date, weatherData);
        }

        return resultCreator.apply(dateWithWeatherData);
    }

    public DayWeatherData getDayWeatherData(String locationCode, List<LocalDate> dates) {
        return getWeatherData(
                dates,
                (date, code) -> WeatherInfoKeyUtils.key(date, code, WeatherSubKeySuffix.TEMPERATURE),
                DayWeatherData::new,
                locationCode
        );
    }

    private MonthWeatherData getMonthWeatherData(String locationCode, List<LocalDate> dates) {
        return getWeatherData(
                dates,
                (date, code) -> WeatherInfoKeyUtils.key(date, code, WeatherSubKeySuffix.PRECIPITATION),
                MonthWeatherData::new,
                locationCode
        );
    }
}
