package com.weatherAPI.weatherApplication.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.weatherAPI.weatherApplication.model.WeatherRequest;
import com.weatherAPI.weatherApplication.model.WeatherResponse;

@Service
public class WeatherService {

    private final RestTemplate restTemplate;
    private final String apiKey;

    public WeatherService(RestTemplate restTemplate, @Value("${weather.api.key}") String apiKey) {
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
    }

    @Cacheable(value = "weatherCache", key = "#request.location + '-' + #request.startDate + '-' + #request.endDate + '-' + #request.locality + '-' + #request.lang")
    public WeatherResponse getWeather(WeatherRequest request) {
        String baseUrl = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline";

        StringBuilder uri = new StringBuilder(baseUrl);
        uri.append("/").append(request.getLocation());

        if (request.hasStartDate()) {
            uri.append("/").append(request.getStartDate());

            if (request.hasEndDate()) {
                uri.append("/").append(request.getEndDate());
            }
        }

        uri.append("?unitGroup=").append(request.getLocality())
            .append("&lang=").append(request.getLang())
            .append("&key=").append(apiKey)
            .append("&contentType=json");

        return restTemplate.getForObject(uri.toString(), WeatherResponse.class);
    }
}

