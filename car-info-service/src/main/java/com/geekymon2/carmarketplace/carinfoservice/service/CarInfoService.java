package com.geekymon2.carmarketplace.carinfoservice.service;

import java.util.List;

import com.geekymon2.carmarketplace.carinfoservice.models.CarMake;
import com.geekymon2.carmarketplace.carinfoservice.models.CarModel;

public interface CarInfoService {
    List<CarMake> getCarMakes();
    List<CarModel> getCarModels(CarMake make);    
}
