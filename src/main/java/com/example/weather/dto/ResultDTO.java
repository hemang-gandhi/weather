package com.example.weather.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultDTO {
    public double dailyAverage;
    public double nightlyAverage;
    public double pressureAverage;

    public double getDailyAverage() {
        return dailyAverage;
    }

    public void setDailyAverage(double dailyAverage) {
        this.dailyAverage = dailyAverage;
    }

    public double getNightlyAverage() {
        return nightlyAverage;
    }

    public void setNightlyAverage(double nightlyAverage) {
        this.nightlyAverage = nightlyAverage;
    }

    public double getPressureAverage() {
        return pressureAverage;
    }

    public void setPressureAverage(double pressureAverage) {
        this.pressureAverage = pressureAverage;
    }
}
