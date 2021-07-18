package com.geekymon2.carmarketplace.carinfoservice.controller;

import java.util.List;

import com.geekymon2.carmarketplace.carinfoservice.models.CarMake;
import com.geekymon2.carmarketplace.carinfoservice.models.CarModel;
import com.geekymon2.carmarketplace.carinfoservice.service.CarInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarInfoController {

    @Autowired
    private CarInfoService service;

    @GetMapping(value = "/makes")
    public List<CarMake> getCarMakes() {
        return service.getCarMakes();
    }

    @GetMapping(value = "/models")
    public List<CarModel> getCarModels(String makeName) {
        return service.getCarModels(new CarMake(makeName));
    }
}
