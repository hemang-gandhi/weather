package com.example.weather.helper;

import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

@Component
public class DateHelper {

	private static final int FORECAST_DAYS = 3;
	private static final int DAY_START = 6;
	private static final int DAY_END = 18;
	private LocalDateTime endDate;
	
	public DateHelper() {
		super();
		this.endDate = getEndDate();
	}
	
	private LocalDateTime getEndDate() {
		Instant currentDate = Instant.now();
		LocalDateTime localDateTime = LocalDateTime.ofInstant(currentDate, ZoneOffset.UTC);
		return localDateTime.plus(FORECAST_DAYS, ChronoUnit.DAYS);
	}
	
	public boolean isDateInRange(Instant dt) {
		LocalDateTime localDateTime = LocalDateTime.ofInstant(dt, ZoneOffset.UTC);
		return localDateTime.getDayOfYear() <= endDate.getDayOfYear();
	}

	public boolean isDayTimeForecast(Instant dt) {
		LocalDateTime localDateTime = LocalDateTime.ofInstant(dt, ZoneOffset.UTC);
		return localDateTime.getHour() >= DAY_START && localDateTime.getHour() <= DAY_END;
	}
	
	
}