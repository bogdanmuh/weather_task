package com.example.demo.service;

import com.example.demo.controller.pojo.Request;
import com.example.demo.controller.pojo.Response;
import com.example.demo.controller.pojo.WeatherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ServiceB {

    final RestTemplate restTemplate;
    final String url = "http://localhost:8080/serviceB/";

    @Autowired
    public ServiceB(@Qualifier("restTemplateserviceB") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void send(WeatherData weatherData, Request request) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
        Response response = new Response(
                request.getMsg(),
                simpleDateFormat.format(new Date()),
                weatherData.getCurrentTemp());

        restTemplate.postForLocation(url, response);
    }

}
