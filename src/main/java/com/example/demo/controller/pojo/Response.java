package com.example.demo.controller.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {

    private String txt;
    private String createdDr;
    private Float currentTemp;

}
