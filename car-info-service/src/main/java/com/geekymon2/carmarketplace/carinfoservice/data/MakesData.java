package com.geekymon2.carmarketplace.carinfoservice.data;

import com.geekymon2.carmarketplace.carinfoservice.models.CarMake;

import java.util.ArrayList;
import java.util.List;

public class MakesData {
    public static List<CarMake> getMakesData() {
        List<CarMake> makes = new ArrayList<CarMake>();
        makes.add(new CarMake("FORD", "USA"));
        makes.add(new CarMake("AUDI", "Germany"));
        makes.add(new CarMake("MAZDA", "Japan"));

        return makes;
    }
}
