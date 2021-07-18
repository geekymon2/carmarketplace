package com.geekymon2.carmarketplace.carinfoservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.geekymon2.carmarketplace.carinfoservice.entities.CarMake;
import com.geekymon2.carmarketplace.carinfoservice.entities.CarModel;
import com.geekymon2.carmarketplace.carinfoservice.repository.CarMakeRepository;
import com.geekymon2.carmarketplace.carinfoservice.service.CarInfoService;
import org.springframework.beans.factory.annotation.Autowired;

public class CarInfoServiceImpl implements CarInfoService {

    @Autowired
    private CarMakeRepository carMakeRepository;

    @Override
    public List<CarMake> getAllCarMakes() {
        List<CarMake> makes = new ArrayList<>();
        carMakeRepository.findAll().addAll(makes);
        return makes;
    }

    @Override
    public List<CarModel> getCarModels(CarMake make) {
        return null;
    }
}
