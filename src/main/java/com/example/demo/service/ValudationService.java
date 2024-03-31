package com.example.demo.service;

import com.example.demo.controller.pojo.Lng;
import com.example.demo.controller.pojo.Request;
import org.springframework.stereotype.Service;

@Service
public class ValudationService {

    public boolean isDataValid(Request request) {
        return request.getLng() != null && request.getLng().equals(Lng.ru) &&
                request.getMsg() != null && !request.getMsg().equals("") &&
                request.getCoordinates() != null &&
                request.getCoordinates().getLatitude() != null && !request.getCoordinates().getLatitude().matches("/^/d{2}./d{2}$/D") &&
                request.getCoordinates().getLongitude() != null && !request.getCoordinates().getLongitude().matches("/^/d{2}./d{2}$/D");
    }

}
