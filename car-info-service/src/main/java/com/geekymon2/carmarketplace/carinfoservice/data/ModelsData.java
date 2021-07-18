package com.geekymon2.carmarketplace.carinfoservice.data;

import com.geekymon2.carmarketplace.carinfoservice.models.CarModelDto;

import java.util.ArrayList;
import java.util.List;

public class ModelsData {

    private ModelsData() {
        super();
    }

    public static List<CarModelDto> getModelsData(String makeName) {

        List<CarModelDto> models = new ArrayList<>();
        if (makeName.equals("FORD")) {
            models.add(new CarModelDto("FALCON"));
        }
        else {
            models.add(new CarModelDto("TUCSON"));
        }

        return models;
    }
}
