package com.weatherAPI.weatherApplication.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.weatherAPI.weatherApplication.model.WeatherResponse;

@Service
public class WeatherService {

    private final RestTemplate restTemplate;
    private final String apiKey;

    public WeatherService(RestTemplate restTemplate, @Value("${weather.api.key}") String apiKey) {
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
    }

    public WeatherResponse getWeather(String location) {
        String uri = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/{location}?unitGroup=us&key={apikey}&contentType=json";
        return restTemplate.getForObject(uri, WeatherResponse.class, location, apiKey);
    }
}

