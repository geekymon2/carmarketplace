package com.geekymon2.carmarketplace.carorchestrator.resources;

import com.geekymon2.carmarketplace.carorchestrator.models.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/car")
public class CarResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{carId}")
    public Car getCarInfo(@PathVariable("carId") String carId) {

        return restTemplate.getForObject("http://car-info-service/api/makes", Car.class);

    }
}