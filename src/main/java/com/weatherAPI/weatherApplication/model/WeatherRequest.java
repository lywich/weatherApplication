package com.weatherAPI.weatherApplication.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class WeatherRequest {
    @NotBlank
    private String location; 
    
    private String startDate;
    private String endDate;

    private String locality = "uk";
    private String lang = "en";

    public boolean hasStartDate() {
        return startDate != null && !startDate.isBlank();
    }

    public boolean hasEndDate() {
        return endDate != null && !endDate.isBlank();
    }
}