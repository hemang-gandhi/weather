package com.example.weather.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherForecast {
    public String cod;
    public String message;
    public Long cnt;
    public List<WeatherDetails> list;
    public City city;

    public List<WeatherDetails> getList() {
        return list;
    }

    public void setList(List<WeatherDetails> list) {
        this.list = list;
    }
}

