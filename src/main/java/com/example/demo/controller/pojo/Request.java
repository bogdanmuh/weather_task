package com.example.demo.controller.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Request {

    private String msg;
    private Lng lng;
    private Coordinates coordinates;

}
