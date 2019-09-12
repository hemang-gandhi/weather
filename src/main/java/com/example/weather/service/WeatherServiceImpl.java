package com.example.weather.service;

import com.example.weather.dto.ResultDTO;
import com.example.weather.dto.WeatherDetails;
import com.example.weather.dto.WeatherForecast;
import com.example.weather.exception.CityNotFoundException;
import com.example.weather.helper.WeatherAverageCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {

	@Autowired
	private	RestTemplate template;

	@Autowired
	private WeatherAverageCalculator weatherAverageCalculator;

	@Value("${weather.appId}")
	private String appId;

	@Value("${weather.url}")
	private String uri;

	@Override
	public ResultDTO getAverageWeatherByCity(String city) throws CityNotFoundException {
		WeatherForecast weatherForecast = new WeatherForecast();
		String owmForecastCityUrl = getForecastUrlForCity(city);
		try {
			weatherForecast = template.getForObject(owmForecastCityUrl, WeatherForecast.class);
		} catch (HttpClientErrorException ex) {
			if (ex.getStatusCode() == HttpStatus.NOT_FOUND) {
				throw new CityNotFoundException(city + " not Found");
			}
		}

		ResultDTO resultDTO = new ResultDTO();
		List<WeatherDetails> weatherDetails = weatherForecast.getList();
		resultDTO.setDailyAverage(
				formatValue(weatherAverageCalculator.getDailyAverage(weatherDetails)));
		resultDTO.setNightlyAverage(
				formatValue(weatherAverageCalculator.getNightlyAverage(weatherDetails)));
		resultDTO.setPressureAverage(
				formatValue(weatherAverageCalculator.getPressureAverage(weatherDetails)));
		return resultDTO;
	}

	private String getForecastUrlForCity(String city) {

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(uri).queryParam("q", city)
				.queryParam("appId", appId).queryParam("units", "metric");
		return builder.toUriString();
	}

	private double formatValue(double doubletoFormat) {
		return Math.round(doubletoFormat * 100) / 100D;
	}
}
