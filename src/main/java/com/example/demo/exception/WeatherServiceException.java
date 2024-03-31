package com.example.demo.exception;

import java.io.IOException;

public class WeatherServiceException extends IOException {

    public WeatherServiceException(String message) {
        super(message);
    }
}
