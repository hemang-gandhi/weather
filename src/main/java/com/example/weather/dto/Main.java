package com.example.weather.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Main {
    public double temp;
    public double temp_min;
    public double temp_max;
    public double pressure;
    public double sea_level;
    public double grnd_level;
    public double humidity;
    public double temp_kf;
}
