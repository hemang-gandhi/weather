package com.example.weather.service;

import com.example.weather.dto.ResultDTO;
import com.example.weather.exception.CityNotFoundException;

public interface WeatherService {
	ResultDTO getAverageWeatherByCity(String city) throws CityNotFoundException;
}
