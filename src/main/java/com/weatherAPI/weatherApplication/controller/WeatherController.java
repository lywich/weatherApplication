package com.weatherAPI.weatherApplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.weatherAPI.weatherApplication.model.WeatherRequest;
import com.weatherAPI.weatherApplication.model.WeatherResponse;
import com.weatherAPI.weatherApplication.service.WeatherService;

import jakarta.validation.Valid;


@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public WeatherResponse getWeather(@Valid @ModelAttribute WeatherRequest req) {
        return weatherService.getWeather(req);
    }
}

