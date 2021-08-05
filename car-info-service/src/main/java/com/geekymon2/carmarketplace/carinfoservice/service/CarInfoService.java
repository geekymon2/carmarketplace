package com.geekymon2.carmarketplace.carinfoservice.service;

import java.util.List;

import com.geekymon2.carmarketplace.carinfoservice.entities.CarMake;
import com.geekymon2.carmarketplace.carinfoservice.entities.CarModel;

public interface CarInfoService {
    List<CarMake> getAllCarMakes();
    long getCarMakesCount();
    CarMake getCarMakeById(long id);
    List<CarModel> getCarModels(String makeName);
}
