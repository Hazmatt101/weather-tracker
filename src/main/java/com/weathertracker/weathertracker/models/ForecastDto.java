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
    private static class Forecast {
        private Instant dateTime;
        private GeneralForecastInfo generalForecastInfo;
        private List<Weather> weather;
        private List<Cloud> clouds;
        private Wind wind;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    private static class GeneralForecastInfo {
        private Double temp;
        private Double tempMin;
        private Double tempMax;
        private Double pressure;
        private Double seaLevel;
        private Double groundLevel;
        private Double humidity;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Weather {
        private String id;
        private String weatherName;
        private String description;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Cloud {
        private Integer numClouds;  //TODO confirm that this is correct
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Wind {
        private Double speed;
        private Double degree;
    }
}
