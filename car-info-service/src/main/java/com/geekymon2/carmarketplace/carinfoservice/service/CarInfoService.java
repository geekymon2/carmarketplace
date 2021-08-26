package com.geekymon2.carmarketplace.carinfoservice.service;

import com.geekymon2.carmarketplace.carinfoservice.entities.CarMake;
import com.geekymon2.carmarketplace.carinfoservice.entities.CarModel;

import java.util.List;

public interface CarInfoService {
    List<CarMake> getAllCarMakes();
    long getCarMakesCount();
    CarMake getCarMakeById(long id);
    CarModel getCarModelById(long id);
    List<CarModel> getCarModels(String makeName, String typeName);
}
