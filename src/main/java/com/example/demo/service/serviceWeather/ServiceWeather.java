package com.example.demo.service.serviceWeather;

import com.example.demo.controller.pojo.Coordinates;
import com.example.demo.controller.pojo.WeatherData;

public abstract class ServiceWeather {

    public abstract WeatherData getWeather(Coordinates coordinates);

    protected abstract WeatherData buildWeatherData(String str);

}
