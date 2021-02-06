package com.weathertracker.weathertracker.services;

import com.weathertracker.weathertracker.models.ForecastDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.http.HttpResponse;

import static org.mockito.Mockito.when;

@ActiveProfiles("test")
public class ForecastServiceTest {
    private ForecastService subject;

    @Mock
    private WebClient webClient;

    @BeforeEach
    public void setUp() {
        subject = new ForecastService();
    }

    @Test
    public void getFiveDayForecast_callsForecastRestTemplateAndReturnsForecastDto() {
//        when(webClient.get()).thenReturn()
        ForecastDto actualForecastDto = subject.getFiveDayForecast();
    }
}