package com.example.demo.config;

import com.example.demo.exception.WeatherServiceException;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

public class WeatherServiceResponseErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse httpResponse) throws IOException {
        return httpResponse.getStatusCode().is5xxServerError() ||
                httpResponse.getStatusCode().is4xxClientError();
    }

    @Override
    public void handleError(ClientHttpResponse httpResponse) throws IOException {
        System.out.println("errorCode - " + httpResponse.getStatusCode());
        throw new WeatherServiceException(httpResponse.getStatusText());
    }

}
