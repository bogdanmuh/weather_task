package com.example.demo.controller;

import com.example.demo.controller.pojo.Request;
import com.example.demo.controller.pojo.WeatherData;
import com.example.demo.service.ServiceB;
import com.example.demo.service.ValudationService;
import com.example.demo.service.serviceWeather.ServiceWeather;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class Controller {

    final ServiceB serviceB;
    final ServiceWeather serviceWeather;
    final ValudationService valudationService;

    @PostMapping(value = "/post")
    public void registration(@RequestBody Request request) {
        if (!valudationService.isDataValid(request))
            return;
        WeatherData weatherdata = serviceWeather.getWeather(request.getCoordinates());
        serviceB.send(weatherdata, request);

        // нужно ли потверждать успешное завершение и пробрасывать исключения возникшие в сервисе
    }

    /*@ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exception.getMessage());
    }*/


}
