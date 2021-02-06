package com.weathertracker.weathertracker.services;

import com.weathertracker.weathertracker.models.ForecastDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ForecastService {
    private final WebClient forecastApiWebClient;

    @Value("${api.forecast-service.url}")
    private String forecastApiUrl;

    @Value("${api.forecast-service.api-key}")
    private String forecastApiKey;

    public ForecastService() {
        forecastApiWebClient = WebClient.builder()
                .baseUrl(forecastApiUrl)
                .build();
    }

    public ForecastDto getFiveDayForecast() {
        Mono<JSONObject> response = forecastApiWebClient.get().uri(uriBuilder -> uriBuilder
                .path("/forecast")
                .queryParam("")
                .build()
        ).retrieve().bodyToMono(JSONObject.class);
        return transformResponseToForecastDto(response);
    }

    private ForecastDto transformResponseToForecastDto(Mono<JSONObject> response) {
        JSONObject responseJson = response.block();
//        return ForecastDto.builder()
//                .forecasts(responseJson.get(""))
//                .build();
        return null;
    }
}
