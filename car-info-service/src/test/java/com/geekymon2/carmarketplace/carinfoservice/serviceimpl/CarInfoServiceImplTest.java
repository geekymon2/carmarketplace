package com.geekymon2.carmarketplace.carinfoservice.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.geekymon2.carmarketplace.carinfoservice.entities.CarMake;

import org.junit.jupiter.api.Test;

class CarInfoServiceImplTest {

    CarInfoServiceImpl service = new CarInfoServiceImpl();

    @Test
    void getAllCarMakes() {
        List<CarMake> expected = new ArrayList<>();
        List<CarMake> actual = service.getAllCarMakes();
        assertEquals(expected, actual, "message");
    }

    @Test
    void getCarMakeById() {
    }

    @Test
    void getCarModels() {
    }

    @Test
    void getAllCarModels() {
    }

    @Test
    void getCarModelById() {
    }

    @Test
    void getCarMakesCount() {
    }
}