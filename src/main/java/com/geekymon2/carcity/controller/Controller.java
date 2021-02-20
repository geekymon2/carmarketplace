package com.geekymon2.carcity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/cars")
    public String getCars() {
        return "A list of cars";
    }

}
