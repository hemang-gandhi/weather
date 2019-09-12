package com.example.weather.exception;

import org.springframework.http.HttpStatus;

public class ApiError {
    private HttpStatus status;
    private String message;
    private String customMessage;

    ApiError(final HttpStatus status, String message, String customMessage) {
        super();
        this.status = status;
        this.message = message;
        this.customMessage = customMessage;
    }

    HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCustomMessage() {
        return customMessage;
    }

    public void setCustomMessage(String customMessage) {
        this.customMessage = customMessage;
    }
}