package com.example.weather.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
	public Long id;
	public String main;
	public String description;
	public String icon;
	
}
