package com.weathertracker.weathertracker.controllers;

import com.weathertracker.weathertracker.services.ForecastService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

public class ForecastControllerTest {
    private ForecastController subject;

    @Mock
    private ForecastService forecastService;

    @BeforeEach
    public void setUp() {
        subject = new ForecastController();
    }

    @Test
    public void getFiveDayForecast_returnsCallsForecastServiceForecastResponse() {
        subject.getFiveDayForecast();
        verify(forecastService.getFiveDayForecast());
    }
}