package com.example.weather.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class LoggingInterceptor implements ClientHttpRequestInterceptor {
 
    private final Logger log = LoggerFactory.getLogger(getClass());
 
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        ClientHttpResponse response = execution.execute(request, body);
        logResponse(response);
        return response;
    }

    private void logResponse(ClientHttpResponse response) throws IOException {
            log.info("Status : {}", response.getStatusCode());
    }
}