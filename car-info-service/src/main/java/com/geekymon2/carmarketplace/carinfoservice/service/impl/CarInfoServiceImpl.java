package com.geekymon2.carmarketplace.carinfoservice.service.impl;

import java.util.List;

import com.geekymon2.carmarketplace.carinfoservice.models.CarMake;
import com.geekymon2.carmarketplace.carinfoservice.models.CarModel;
import com.geekymon2.carmarketplace.carinfoservice.service.CarInfoService;

public class CarInfoServiceImpl implements CarInfoService {

    @Override
    public List<CarMake> getCarMakes() {
        throw new Exception("Not implemented");
    }

    @Override
    public List<CarModel> getCarModels(CarMake make) {
        throw new Exception("Not implemented");
    }
    
}
