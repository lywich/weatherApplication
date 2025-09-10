package com.weatherAPI.weatherApplication.controller;

import java.time.Duration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.weatherAPI.weatherApplication.model.WeatherRequest;
import com.weatherAPI.weatherApplication.model.WeatherResponse;
import com.weatherAPI.weatherApplication.service.WeatherService;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import jakarta.validation.Valid;


@RestController
public class WeatherController {

    private final WeatherService weatherService;
    private final Bucket bucket;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
        Bandwidth limit = Bandwidth.classic(5, Refill.greedy(1, Duration.ofMinutes(1)));
        this.bucket = Bucket.builder().addLimit(limit).build();
    }

    @GetMapping("/weather")
    public ResponseEntity<WeatherResponse> getWeather(@Valid @ModelAttribute WeatherRequest req) {
        if (!bucket.tryConsume(1)) {
            System.out.println("Token limit reached");
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();
        }
        return ResponseEntity.ok(weatherService.getWeather(req));
    }
}

