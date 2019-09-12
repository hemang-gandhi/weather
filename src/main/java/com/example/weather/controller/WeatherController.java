package com.example.weather.controller;

import com.example.weather.dto.ResultDTO;
import com.example.weather.exception.CityNotFoundException;
import com.example.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @RequestMapping(value = "/average", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    ResultDTO getAverageWeatherByCity(@RequestParam(value = "city") String city) throws CityNotFoundException {
        return weatherService.getAverageWeatherByCity(city);
    }

}
