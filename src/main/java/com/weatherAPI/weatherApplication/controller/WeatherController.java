package com.weatherAPI.weatherApplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.weatherAPI.weatherApplication.model.WeatherResponse;
import com.weatherAPI.weatherApplication.service.WeatherService;


@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public WeatherResponse getWeather(@RequestParam String location) {
        return weatherService.getWeather(location);
    }
}

