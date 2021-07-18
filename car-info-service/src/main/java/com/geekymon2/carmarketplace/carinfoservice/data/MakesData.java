package com.geekymon2.carmarketplace.carinfoservice.data;

import java.util.ArrayList;
import java.util.List;

import com.geekymon2.carmarketplace.carinfoservice.models.CarMakeDto;

public class MakesData {

    private MakesData() {
        super();
    }
    
    public static List<CarMakeDto> getMakesData() {
        List<CarMakeDto> makes = new ArrayList<>();
        makes.add(new CarMakeDto("FORD", "USA"));
        makes.add(new CarMakeDto("AUDI", "Germany"));
        makes.add(new CarMakeDto("BMW", "Germany"));
        makes.add(new CarMakeDto("MAZDA", "Japan"));
        makes.add(new CarMakeDto("TOYOTA", "Japan"));
        makes.add(new CarMakeDto("FERRARI", "Italy"));
        makes.add(new CarMakeDto("FIAT", "Italy"));
        makes.add(new CarMakeDto("HOLDEN", "Australia"));
        makes.add(new CarMakeDto("HONDA", "Japan"));
        makes.add(new CarMakeDto("HYUNDIA", "South Korea"));
        makes.add(new CarMakeDto("KIA", "South Korea"));
        makes.add(new CarMakeDto("LAMBORGHINI", "Italy"));
        makes.add(new CarMakeDto("LAND ROVER", "England"));
        makes.add(new CarMakeDto("LEXUS", "Japan"));
        makes.add(new CarMakeDto("MERCEDES-BENZ", "Germany"));
        makes.add(new CarMakeDto("MITSUBISHI", "Japan"));
        makes.add(new CarMakeDto("NISSAN", "Japan"));
        makes.add(new CarMakeDto("SUBARU", "Japan"));
        makes.add(new CarMakeDto("SUZUKI", "Japan"));
        makes.add(new CarMakeDto("VOLKSWAGEN", "Germany"));

        return makes;
    }
}
