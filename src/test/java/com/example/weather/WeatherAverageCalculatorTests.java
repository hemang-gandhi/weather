package com.example.weather;

import com.example.weather.dto.WeatherDetails;
import com.example.weather.helper.DateHelper;
import com.example.weather.helper.WeatherAverageCalculator;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class WeatherAverageCalculatorTests {

    @Autowired
    private WeatherAverageCalculator calculator;

    @Autowired
    private
    DateHelper dateHelper;

    @Before
    public void setUp() {
        calculator = new WeatherAverageCalculator();
        dateHelper = new DateHelper();
    }

    @Test
    public void testDailyAverage() {
        List<WeatherDetails> wd1 = WeatherTestsHelper.getDailyWeatherDetails();
        double expected = wd1.stream()
                .filter(details -> dateHelper.isDateInRange(details.dt))
                .filter(details -> dateHelper.isDayTimeForecast(details.dt))
                .mapToDouble(details -> details.main.temp).summaryStatistics().getAverage();
        assertEquals("DailyAverage", expected, 8.0, 0.0);
    }

    @Test
    public void testNightlyAverage() {
        List<WeatherDetails> wd1 = WeatherTestsHelper.getDailyWeatherDetails();
        double expected = wd1.stream()
                .filter(details -> dateHelper.isDateInRange(details.dt))
                .filter(details -> !dateHelper.isDayTimeForecast(details.dt))
                .mapToDouble(details -> details.main.temp).summaryStatistics().getAverage();
        assertEquals("NightlyAverage", expected, 4.00, 0);
    }

    @Test
    public void testPressure() {
        List<WeatherDetails> wd1 = WeatherTestsHelper.getDailyWeatherDetails();
        double expected = wd1.stream()
                .filter(details -> dateHelper.isDateInRange(details.dt))
                .mapToDouble(details -> details.main.pressure)
                .summaryStatistics().getAverage();
        assertEquals("NightlyAverage", expected, 125.00, 0);
    }
}
