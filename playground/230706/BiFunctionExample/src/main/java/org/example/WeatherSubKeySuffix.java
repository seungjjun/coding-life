package org.example;

public enum WeatherSubKeySuffix {
    TEMPERATURE("temperature"),
    PRECIPITATION("precipitation");

    private String suffix;

    WeatherSubKeySuffix(String suffix) {
        this.suffix = suffix;
    }

    @Override
    public String toString() {
        return suffix;
    }
}
