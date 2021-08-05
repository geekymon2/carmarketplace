package com.geekymon2.carmarketplace.carinfoservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.geekymon2.carmarketplace.carinfoservice.entities.CarMake;
import com.geekymon2.carmarketplace.carinfoservice.entities.CarModel;
import com.geekymon2.carmarketplace.carinfoservice.models.CarMakeDto;
import com.geekymon2.carmarketplace.carinfoservice.models.CarModelDto;
import com.geekymon2.carmarketplace.carinfoservice.service.impl.CarInfoServiceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarInfoController {

    @Autowired
    private CarInfoServiceImpl service;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "/makes")
    public List<CarMakeDto> getCarMakes() {
        return service.getAllCarMakes().stream().map(this::makeToDto).collect(Collectors.toList());
    }

    @GetMapping(value = "/makes/count")
    public long getCarMakesCount() {
        return service.getCarMakesCount();
    }

    @GetMapping(value = "/models")
    public List<CarModelDto> getCarModels(String makeName) {
        return service.getCarModels(makeName).stream().map(this::modelToDto).collect(Collectors.toList());
    }

    private CarMakeDto makeToDto(CarMake make) {
        return modelMapper.map(make, CarMakeDto.class);
    }

    private CarModelDto modelToDto(CarModel model) {
        return modelMapper.map(model, CarModelDto.class);
    }    
}
