package com.example.weather.exception;

public class CityNotFoundException extends Exception {
	
	private static final long serialVersionUID = 8516397051764053808L;
	
	public CityNotFoundException(String message) {
		super(message);
	}
}
