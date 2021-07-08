package com.geekymon2.carmarketplace.carinfoservice.data;

import com.geekymon2.carmarketplace.carinfoservice.models.CarMake;
import com.geekymon2.carmarketplace.carinfoservice.models.CarModel;

import java.util.ArrayList;
import java.util.List;

public class ModelsData {
    public static List<CarModel> getModelsData(String makeName) {
        List<CarModel> models = new ArrayList<CarModel>();
        models.add(new CarModel("FALCON"));
        return models;
    }
}
