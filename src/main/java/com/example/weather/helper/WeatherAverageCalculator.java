package com.example.weather.helper;

import com.example.weather.dto.WeatherDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WeatherAverageCalculator {

    @Autowired
    private DateHelper dateHelper;

    public double getDailyAverage(List<WeatherDetails> weatherDetails) {
        return weatherDetails.stream()
                .filter(details -> dateHelper.isDateInRange(details.dt))
                .filter(details -> dateHelper.isDayTimeForecast(details.dt))
                .mapToDouble(details -> details.main.temp).summaryStatistics().getAverage();
    }

    public double getNightlyAverage(List<WeatherDetails> weatherDetails) {
        return weatherDetails.stream()
                .filter(details -> dateHelper.isDateInRange(details.dt))
                .filter(details -> !dateHelper.isDayTimeForecast(details.dt))
                .mapToDouble(details -> details.main.temp).summaryStatistics().getAverage();
    }

    public double getPressureAverage(List<WeatherDetails> weatherDetails) {
        return weatherDetails.stream()
                .filter(details -> dateHelper.isDateInRange(details.dt))
                .mapToDouble(details -> details.main.pressure)
                .summaryStatistics().getAverage();
    }

}
