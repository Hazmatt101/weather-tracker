package com.weathertracker.weathertracker.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ForecastDto {
    private List<Forecast> forecasts;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Forecast {
        private Instant dateTime;
        private GeneralForecastInfo generalForecastInfo;
        private List<Weather> weather;
        private Clouds clouds;
        private Wind wind;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GeneralForecastInfo {
        private Double temp;
        private Double tempMin;
        private Double tempMax;
        private Double pressure;
        private Double seaLevel;
        private Double groundLevel;
        private Integer humidity;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Weather {
        private String id;
        private String weatherName;
        private String description;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Clouds {
        private Integer numClouds;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Wind {
        private Double speed;
        private Double degree;
    }
}
