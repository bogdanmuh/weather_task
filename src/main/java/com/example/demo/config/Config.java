package com.example.demo.config;

import com.example.demo.service.serviceWeather.OpenMeteoService;
import com.example.demo.service.serviceWeather.ServiceWeather;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

    @Bean
    // @codition создать бин по условию
    public ServiceWeather getServiceWeather(){
        return new OpenMeteoService(getRestTemplateForWeatherService());
    }

    @Bean(name="restTemplateweather")
    public RestTemplate getRestTemplateForWeatherService(){
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setConnectTimeout(10000);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        restTemplate.setErrorHandler(new WeatherServiceResponseErrorHandler());
        return restTemplate;
    }

    @Bean(name="restTemplateserviceB")
    public RestTemplate getRestTemplateForService(){
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setConnectTimeout(10000);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        restTemplate.setErrorHandler(new ServiceBResponseErrorHandler()); //TODO change
        return restTemplate;
    }

}
