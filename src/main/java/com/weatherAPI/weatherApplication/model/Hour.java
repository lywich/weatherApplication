package com.weatherAPI.weatherApplication.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Hour {
    private String datetime;
    private long datetimeEpoch;
    private double temp;
    private double feelslike;
    private double humidity;
    private double dew;
    private double precip;
    private double precipprob;
    private double snow;
    private Object snowdepth;
    private List<String> preciptype;
    private double windgust;
    private double windspeed;
    private double winddir;
    private double pressure;
    private double visibility;
    private double cloudcover;
    private double solarradiation;
    private double solarenergy;
    private int uvindex;
    private double severerisk;
    private String conditions;
    private String icon;
    private List<String> stations;
    private String source;
}
