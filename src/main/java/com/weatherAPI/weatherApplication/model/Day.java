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
public class Day {
    private String datetime;
    private long datetimeEpoch;
    private double tempmax;
    private double tempmin;
    private double temp;
    private double feelslikemax;
    private double feelslikemin;
    private double feelslike;
    private double dew;
    private double humidity;
    private double precip;
    private double precipprob;
    private double precipcover;
    private List<String> preciptype;
    private double snow;
    private Object snowdepth;  // can be null
    private double windgust;
    private double windspeed;
    private double winddir;
    private double pressure;
    private double cloudcover;
    private double visibility;
    private double solarradiation;
    private double solarenergy;
    private int uvindex;
    private double severerisk;
    private String sunrise;
    private long sunriseEpoch;
    private String sunset;
    private long sunsetEpoch;
    private double moonphase;
    private String conditions;
    private String description;
    private String icon;
    private List<String> stations;
    private String source;
    private List<Hour> hours;
}