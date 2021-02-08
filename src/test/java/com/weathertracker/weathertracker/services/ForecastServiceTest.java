package com.weathertracker.weathertracker.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weathertracker.weathertracker.models.ForecastDto;
import com.weathertracker.weathertracker.models.ForecastDto.*;
import com.weathertracker.weathertracker.utils.TestUtils;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;
import java.time.Instant;
import java.util.Collections;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
public class ForecastServiceTest {
    private static MockWebServer mockWebServer;
    private static JSONObject mockForecastJson;

    private ForecastService subject;

    @BeforeAll
    public static void setUpBeforeAll() throws IOException, ParseException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
        mockForecastJson = TestUtils.createJsonFromFile("src/test/resources/sample-responses/forecast-sample-response.json");
    }

    @BeforeEach
    public void setUpBeforeEach() {
        String baseUrl = String.format("http://localhost:%s", mockWebServer.getPort());
        subject = new ForecastService();
    }

    @AfterAll
    public static void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

    @Test
    public void getFiveDayForecast_callsForecastRestTemplateAndReturnsForecastDto() throws JsonProcessingException {
        ForecastDto expectedForecastDto = getExpectedForecastDto();
        mockWebServer.enqueue(new MockResponse()
                .setBody(new ObjectMapper().writeValueAsString(mockForecastJson))
                .addHeader("Content-Type", "application/json"));
        ForecastDto actualForecastDto = subject.getFiveDayForecast();
        assertThat(actualForecastDto).isEqualTo(expectedForecastDto);
    }

    private ForecastDto getExpectedForecastDto() {
        return ForecastDto.builder()
                .forecasts(asList(
                        Forecast.builder()
                                .dateTime(Instant.ofEpochMilli(1612753200))
                                .generalForecastInfo(
                                        GeneralForecastInfo.builder()
                                                .temp(15.33)
                                                .tempMin(15.21)
                                                .tempMax(15.33)
                                                .pressure(1013.0)
                                                .seaLevel(1013.0)
                                                .groundLevel(1012.0)
                                                .humidity(73)
                                                .build())
                                .weather(Collections.singletonList(
                                        Weather.builder()
                                                .id("800")
                                                .weatherName("Clear")
                                                .description("clear sky")
                                                .build()
                                ))
                                .clouds(Clouds.builder().numClouds(10).build())
                                .wind(
                                        Wind.builder()
                                                .speed(2.04)
                                                .degree(195.0)
                                                .build())
                                .build(),
                        Forecast.builder()
                                .dateTime(Instant.ofEpochMilli(1612764000))
                                .generalForecastInfo(
                                        GeneralForecastInfo.builder()
                                                .temp(14.79)
                                                .tempMin(14.61)
                                                .tempMax(14.79)
                                                .pressure(1014.0)
                                                .seaLevel(1014.0)
                                                .groundLevel(1013.0)
                                                .humidity(72)
                                                .build())
                                .weather(Collections.singletonList(
                                        Weather.builder()
                                                .id("800")
                                                .weatherName("Clear")
                                                .description("clear sky")
                                                .build()
                                ))
                                .clouds(Clouds.builder().numClouds(4).build())
                                .wind(
                                        Wind.builder()
                                                .speed(2.04)
                                                .degree(168.0)
                                                .build())
                                .build()
                ))
                .build();
    }
}