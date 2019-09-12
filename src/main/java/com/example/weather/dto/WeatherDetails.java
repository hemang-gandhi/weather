package com.example.weather.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Data
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDetails {
    public Instant dt;
    public Main main;
    public Weather[] weather;
    public Clouds clouds;
    public Wind wind;
    public Rain rain;
    public Snow snow;
    public Sys sys;
    public String dt_txt;
}
