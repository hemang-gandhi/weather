package com.example.weather;

import com.example.weather.dto.Main;
import com.example.weather.dto.WeatherDetails;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Component
class WeatherTestsHelper {

	static List<WeatherDetails> getDailyWeatherDetails() {
		List<WeatherDetails> list = new ArrayList<>();

		WeatherDetails wd1 = new WeatherDetails();
		wd1.dt = Instant.parse("2019-09-09T06:00:00Z");
		Main main1 = new Main();
		main1.temp = 10.00;
		main1.pressure = 100.00;
		wd1.main = main1;
		list.add(wd1);

		WeatherDetails wd2 = new WeatherDetails();
		wd2.dt = Instant.parse("2019-09-09T09:00:00Z");
		Main main2 = new Main();
		main2.temp = 6.00;
		main2.pressure = 200.00;
		wd2.main = main2;
		list.add(wd2);
		
		WeatherDetails wd3 = new WeatherDetails();
		wd3.dt = Instant.parse("2019-09-09T21:00:00Z");
		Main main3 = new Main();
		main3.temp = 4.00;
		main3.pressure = 100.00;
		wd3.main = main3;
		list.add(wd3);

		WeatherDetails wd4 = new WeatherDetails();
		wd4.dt = Instant.parse("2019-09-09T19:00:00Z");
		Main main4 = new Main();
		main4.temp = 4.00;
		main4.pressure = 100.00;
		wd4.main = main4;
		list.add(wd4);
		
		return list;
	}
}
