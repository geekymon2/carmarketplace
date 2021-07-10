package com.geekymon2.carmarketplace.carinfoservice.data;

import com.geekymon2.carmarketplace.carinfoservice.models.CarModel;

import java.util.ArrayList;
import java.util.List;

public class ModelsData {

    private ModelsData() {
        super();
    }

    public static List<CarModel> getModelsData(String makeName) {

        List<CarModel> models = new ArrayList<>();
        if (makeName.equals("FORD")) {
            models.add(new CarModel("FALCON"));
        }
        else {
            models.add(new CarModel("TUCSON"));
        }

        return models;
    }
}
