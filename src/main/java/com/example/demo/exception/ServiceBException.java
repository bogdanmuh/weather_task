package com.example.demo.exception;

import java.io.IOException;

public class ServiceBException extends IOException {

    public ServiceBException(String message) {
        super(message);
    }
}