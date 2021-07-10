package com.geekymon2.carmarketplace.carinfoservice.resources;

import java.util.List;

import com.geekymon2.carmarketplace.carinfoservice.data.MakesData;
import com.geekymon2.carmarketplace.carinfoservice.data.ModelsData;
import com.geekymon2.carmarketplace.carinfoservice.models.CarMake;
import com.geekymon2.carmarketplace.carinfoservice.models.CarModel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarInfoResource {
    @GetMapping(value = "/makes")
    public List<CarMake> getCarMakes() {
        return MakesData.getMakesData();
    }

    @GetMapping(value = "/models")
    public List<CarModel> getCarModels(String makeName) {
        return ModelsData.getModelsData(makeName);
    }
}
