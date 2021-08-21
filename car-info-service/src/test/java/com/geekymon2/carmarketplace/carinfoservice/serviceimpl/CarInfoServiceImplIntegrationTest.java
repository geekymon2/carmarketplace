package com.geekymon2.carmarketplace.carinfoservice.serviceimpl;

import com.geekymon2.carmarketplace.carinfoservice.entities.CarMake;
import com.geekymon2.carmarketplace.carinfoservice.repository.CarMakeRepository;
import com.geekymon2.carmarketplace.carinfoservice.repository.CarModelRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureTestDatabase
@TestPropertySource(locations = "classpath:application-integration-test.properties")
public class CarInfoServiceImplIntegrationTest {

    @Autowired
    private CarMakeRepository carMakeRepository;

    @Autowired
    private CarModelRepository carModelRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Check for all car makes from the h2 database and ensure that they match the h2 data init sql.")
    void getAllCarMakesTestValid() {
        CarInfoServiceImpl impl = new CarInfoServiceImpl(carMakeRepository, carModelRepository);
        List<CarMake> actual = impl.getAllCarMakes();
        List<CarMake> expected = generateValidMakeData();
        assertThat(expected.equals(actual)).isTrue();
    }

    @Test
    @DisplayName("Check for all car makes from the h2 database and ensure that they match the h2 data init sql.")
    void getAllCarMakesTestInValid() {
        CarInfoServiceImpl impl = new CarInfoServiceImpl(carMakeRepository, carModelRepository);
        List<CarMake> actual = impl.getAllCarMakes();
        List<CarMake> expected = generateInValidMakeData();
        assertThat(expected.equals(actual)).isFalse();
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

    //* This needs to match the make data in data.sql for the integration tests to be successful.
    private List<CarMake> generateValidMakeData() {
        List<CarMake> makes = new ArrayList();
        makes.add(new CarMake((long)1,"FORD","USA"));
        makes.add(new CarMake((long)2,"AUDI","Germany"));
        return makes;
    }

    //* This should not match the make data in data.sql for the integration tests to be successful.
    private List<CarMake> generateInValidMakeData() {
        List<CarMake> makes = new ArrayList();
        makes.add(new CarMake((long)1,"XXXX","XXXX"));
        makes.add(new CarMake((long)1,"YYYY","YYYY"));
        return makes;
    }
}