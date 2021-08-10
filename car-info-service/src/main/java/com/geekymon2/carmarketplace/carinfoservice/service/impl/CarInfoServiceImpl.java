package com.geekymon2.carmarketplace.carinfoservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.geekymon2.carmarketplace.carinfoservice.entities.CarMake;
import com.geekymon2.carmarketplace.carinfoservice.entities.CarModel;
import com.geekymon2.carmarketplace.carinfoservice.repository.CarMakeRepository;
import com.geekymon2.carmarketplace.carinfoservice.repository.CarModelRepository;
import com.geekymon2.carmarketplace.carinfoservice.service.CarInfoService;
import org.springframework.beans.factory.annotation.Autowired;

public class CarInfoServiceImpl implements CarInfoService {

    @Autowired
    private CarMakeRepository carMakeRepository;

    @Autowired
    private CarModelRepository carModelRepository;

    @Override
    public List<CarMake> getAllCarMakes() {
        List<CarMake> makes = new ArrayList<>();
        carMakeRepository.findAll().forEach(makes::add);
        return makes;
    }

    @Override
    public CarMake getCarMakeById(long id) {
        Optional<CarMake> make;
        make  = carMakeRepository.findById(id);
        return make.get();
    }

    @Override
    public List<CarModel> getCarModels(String makeName) {
        CarMake make = carMakeRepository.findOneByName(makeName);
        return carModelRepository.findByMakeId(make.getId()); 
    }

    @Override
    public CarModel getCarModelById(long id) {
        Optional<CarModel> model;
        model  = carModelRepository.findById(id);
        return model.get();
    }

    @Override
    public long getCarMakesCount() {
        return carMakeRepository.count();
    }
}
