package com.geekymon2.carmarketplace.carinfoservice.resources;

import com.geekymon2.carmarketplace.carinfoservice.models.Car;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarInfoResource {
    @RequestMapping("/{carId}")
    public Car getCarInfo(@PathVariable("carId") String carId) {
        return new Car(1,
                "FORD",
                "FALCON",
                2009,
                4,
                5,
                140000,
                "Ford Falcon G6E"
                );
    }

}
