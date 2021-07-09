package com.geekymon2.carmarketplace.carinfoservice.data;

import com.geekymon2.carmarketplace.carinfoservice.models.CarMake;

import java.util.ArrayList;
import java.util.List;

public class MakesData {
    public static List<CarMake> getMakesData() {
        List<CarMake> makes = new ArrayList<>();
        makes.add(new CarMake("FORD", "USA"));
        makes.add(new CarMake("AUDI", "Germany"));
        makes.add(new CarMake("BMW", "Germany"));
        makes.add(new CarMake("MAZDA", "Japan"));
        makes.add(new CarMake("TOYOTA", "Japan"));
        makes.add(new CarMake("FERRARI", "Italy"));
        makes.add(new CarMake("FIAT", "Italy"));
        makes.add(new CarMake("HOLDEN", "Australia"));
        makes.add(new CarMake("HONDA", "Japan"));
        makes.add(new CarMake("HYUNDIA", "South Korea"));
        makes.add(new CarMake("KIA", "South Korea"));
        makes.add(new CarMake("LAMBORGHINI", "Italy"));
        makes.add(new CarMake("LAND ROVER", "England"));
        makes.add(new CarMake("LEXUS", "Japan"));
        makes.add(new CarMake("MERCEDES-BENZ", "Germany"));
        makes.add(new CarMake("MITSUBISHI", "Japan"));
        makes.add(new CarMake("NISSAN", "Japan"));
        makes.add(new CarMake("SUBARU", "Japan"));
        makes.add(new CarMake("SUZUKI", "Japan"));
        makes.add(new CarMake("VOLKSWAGEN", "Germany"));

        return makes;
    }
}
