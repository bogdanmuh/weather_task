package com.example.demo.service.serviceWeather;

import com.example.demo.controller.pojo.Coordinates;
import com.example.demo.controller.pojo.WeatherData;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.client.RestTemplate;


public class OpenMeteoService extends ServiceWeather {
    final String url = "https://api.open-meteo.com/v1/forecast?latitude=%s&longitude=%s&current=temperature_2m";

    final RestTemplate restTemplate;

    @Autowired
    public OpenMeteoService(@Qualifier("weather") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public WeatherData getWeather(Coordinates coordinates) {
        return buildWeatherData(restTemplate.getForObject(String.format(url, coordinates.getLatitude(), coordinates.getLongitude()), String.class));
    }

    @Override
    protected WeatherData buildWeatherData(String str) {
        JSONObject json = new JSONObject(str);
        String temperature = json.getJSONObject("current").get("temperature_2m").toString();
        return new WeatherData(Float.valueOf(temperature));
    }

}
