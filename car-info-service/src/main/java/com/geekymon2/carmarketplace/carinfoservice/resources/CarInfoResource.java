package com.geekymon2.carmarketplace.carinfoservice.resources;

import com.geekymon2.carmarketplace.carinfoservice.data.MakesData;
import com.geekymon2.carmarketplace.carinfoservice.data.ModelsData;
import com.geekymon2.carmarketplace.carinfoservice.models.CarMake;
import com.geekymon2.carmarketplace.carinfoservice.models.CarModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/car")
public class CarInfoResource {
    @RequestMapping(value = "/makes", method = RequestMethod.GET)
    public List<CarMake> getCarMakes() {
        return MakesData.getMakesData();
    }

    @GetMapping
    @RequestMapping(value = "/models", method = RequestMethod.GET)
    public List<CarModel> getCarModels(String makeName) {
        return ModelsData.getModelsData(makeName);
    }

}
