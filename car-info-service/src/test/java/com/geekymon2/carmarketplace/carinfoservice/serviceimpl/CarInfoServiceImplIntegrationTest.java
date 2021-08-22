package com.geekymon2.carmarketplace.carinfoservice.serviceimpl;

import com.geekymon2.carmarketplace.carinfoservice.entities.CarMake;
import com.geekymon2.carmarketplace.carinfoservice.entities.CarModel;
import com.geekymon2.carmarketplace.carinfoservice.entities.CarModelType;
import com.geekymon2.carmarketplace.carinfoservice.repository.CarMakeRepository;
import com.geekymon2.carmarketplace.carinfoservice.repository.CarModelRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
@AutoConfigureTestDatabase
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
public class CarInfoServiceImplIntegrationTest {

    private final CarMakeRepository carMakeRepository;
    private final CarModelRepository carModelRepository;

    @Autowired
    public CarInfoServiceImplIntegrationTest(CarMakeRepository carMakeRepository, CarModelRepository carModelRepository) {
        this.carMakeRepository = carMakeRepository;
        this.carModelRepository = carModelRepository;
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Test all valid car makes.")
    void getAllCarMakesValidTest() {
        CarInfoServiceImpl impl = new CarInfoServiceImpl(carMakeRepository, carModelRepository);
        List<CarMake> actual = impl.getAllCarMakes();
        List<CarMake> expected = generateValidMakeData();
        assertThat(expected.equals(actual)).isTrue();
    }

    @Test
    @DisplayName("Test for invalid car make.")
    void getAllCarMakesInValidTest() {
        CarInfoServiceImpl impl = new CarInfoServiceImpl(carMakeRepository, carModelRepository);
        List<CarMake> actual = impl.getAllCarMakes();
        List<CarMake> expected = generateInValidMakeData();
        assertThat(expected.equals(actual)).isFalse();
    }

    @Test
    @DisplayName("Test valid car make by id.")
    void getCarMakeByIdValidTest() {
        CarInfoServiceImpl impl = new CarInfoServiceImpl(carMakeRepository, carModelRepository);
        CarMake actual = impl.getCarMakeById(1L);
        CarMake expected = new CarMake(1L, "FORD", "USA");
        assertThat(expected.equals(actual)).isTrue();
    }

    @Test
    @DisplayName("Test invalid car make by id.")
    void getCarMakeByIdInValidTest() {
        CarInfoServiceImpl impl = new CarInfoServiceImpl(carMakeRepository, carModelRepository);
        CarMake actual = impl.getCarMakeById(1L);
        CarMake expected = new CarMake(99L, "XXX", "XXX");
        assertThat(expected.equals(actual)).isFalse();
    }

    @Test
    @DisplayName("Test car models filter on make and type.")
    void getCarModelsByMakeAndTypeTest() {
        CarInfoServiceImpl impl = new CarInfoServiceImpl(carMakeRepository, carModelRepository);
        List<CarModel> actual = impl.getCarModels("FORD", "SEDAN");
        List<CarModel>  expected = new ArrayList<>();

        CarMake ford = new CarMake(1L,"FORD","USA");

        expected.add(new CarModel(1L, "Ford Falcon", ford, CarModelType.SEDAN));
        expected.add(new CarModel(2L, "Ford Focus Sedan", ford, CarModelType.SEDAN));

        assertThat(expected.equals(actual)).isTrue();
    }

    @Test
    @DisplayName("Test car models filter on type.")
    void getCarModelsByTypeTest() {
        CarInfoServiceImpl impl = new CarInfoServiceImpl(carMakeRepository, carModelRepository);
        List<CarModel> actual = impl.getCarModels(null, "SEDAN");
        List<CarModel>  expected = new ArrayList<>();

        CarMake ford = new CarMake(1L,"FORD","USA");
        CarMake audi = new CarMake(2L,"AUDI","Germany");

        expected.add(new CarModel(1L, "Ford Falcon", ford, CarModelType.SEDAN));
        expected.add(new CarModel(2L, "Ford Focus Sedan", ford, CarModelType.SEDAN));
        expected.add(new CarModel(5L, "Audi A4 Sedan", audi, CarModelType.SEDAN));
        expected.add(new CarModel(6L, "Audi S4 Sedan", audi, CarModelType.SEDAN));
        expected.add(new CarModel(7L, "Audi A6 Sedan", audi, CarModelType.SEDAN));

        assertThat(expected.equals(actual)).isTrue();
    }

    @Test
    @DisplayName("Test car models filter on make.")
    void getCarModelsByMakeTest() {
        CarInfoServiceImpl impl = new CarInfoServiceImpl(carMakeRepository, carModelRepository);
        List<CarModel> actual = impl.getCarModels("AUDI", null);
        List<CarModel>  expected = new ArrayList<>();

        CarMake audi = new CarMake(1L,"AUDI","Germany");

        expected.add(new CarModel(5L, "Audi A4 Sedan", audi, CarModelType.SEDAN));
        expected.add(new CarModel(6L, "Audi S4 Sedan", audi, CarModelType.SEDAN));
        expected.add(new CarModel(7L, "Audi A6 Sedan", audi, CarModelType.SEDAN));
        expected.add(new CarModel(8L, "Audi Q2", audi, CarModelType.SUV));

        assertThat(expected.equals(actual)).isTrue();
    }

    @Test
    @DisplayName("Test all valid car models.")
    void getAllCarModelsValidTest() {
        CarInfoServiceImpl impl = new CarInfoServiceImpl(carMakeRepository, carModelRepository);
        List<CarModel> actual = impl.getAllCarModels();
        List<CarModel> expected = generateValidModelsData();
        assertThat(expected.equals(actual)).isTrue();
    }

    @Test
    @DisplayName("Test valid car model by id.")
    void getCarModelByIdValidTest() {
        CarInfoServiceImpl impl = new CarInfoServiceImpl(carMakeRepository, carModelRepository);
        CarModel actual = impl.getCarModelById(1L);
        CarModel expected = new CarModel(1L, "Ford Falcon", new CarMake(1L, "FORD", "USA"), CarModelType.SEDAN);
        assertThat(expected.equals(actual)).isTrue();
    }

    @Test
    @DisplayName("Test invalid car model by id.")
    void getCarModelByIdInValidTest() {
        CarInfoServiceImpl impl = new CarInfoServiceImpl(carMakeRepository, carModelRepository);
        CarModel actual = impl.getCarModelById(1L);
        CarModel expected = new CarModel(999L, "XXX", new CarMake(999L, "XXX", "XXX"), CarModelType.UTE);
        assertThat(expected.equals(actual)).isFalse();
    }

    @Test
    @DisplayName("Test invalid car makes count.")
    void getCarMakesCountInValidTest() {
        CarInfoServiceImpl impl = new CarInfoServiceImpl(carMakeRepository, carModelRepository);
        long actual = impl.getCarMakesCount();
        long expected = 999;
        assertNotEquals(expected, actual);
    }

    @Test
    @DisplayName("Test valid car makes count.")
    void getCarMakesCountValidTest() {
        CarInfoServiceImpl impl = new CarInfoServiceImpl(carMakeRepository, carModelRepository);
        long actual = impl.getCarMakesCount();
        long expected = 2;
        assertEquals(expected, actual);
    }

    //* This needs to match the make data in data.sql for the integration tests to be successful.
    private List<CarMake> generateValidMakeData() {
        List<CarMake> makes = new ArrayList<>();
        makes.add(new CarMake(1L,"FORD","USA"));
        makes.add(new CarMake(2L,"AUDI","Germany"));
        return makes;
    }

    //* This needs to match the make data in data.sql for the integration tests to be successful.
    private List<CarModel> generateValidModelsData() {
        List<CarModel> models = new ArrayList<>();
        CarMake ford = new CarMake(1L,"FORD","USA");
        CarMake audi = new CarMake(2L,"AUDI","Germany");

        models.add(new CarModel(1L, "Ford Falcon", ford, CarModelType.SEDAN));
        models.add(new CarModel(2L, "Ford Focus Sedan", ford, CarModelType.SEDAN));
        models.add(new CarModel(3L, "Ford Focus Hatch", ford, CarModelType.HATCHBACK));
        models.add(new CarModel(4L, "Ford Puma", ford, CarModelType.SUV));

        models.add(new CarModel(5L, "Audi A4 Sedan", audi, CarModelType.SEDAN));
        models.add(new CarModel(6L, "Audi S4 Sedan", audi, CarModelType.SEDAN));
        models.add(new CarModel(7L, "Audi A6 Sedan", audi, CarModelType.SEDAN));
        models.add(new CarModel(8L, "Audi Q2", audi, CarModelType.SUV));

        return models;
    }

    //* This should not match the make data in data.sql for the integration tests to be successful.
    private List<CarMake> generateInValidMakeData() {
        List<CarMake> makes = new ArrayList<>();
        makes.add(new CarMake(1L,"XXX","XXX"));
        makes.add(new CarMake(2L,"YYY","YYY"));
        return makes;
    }
}