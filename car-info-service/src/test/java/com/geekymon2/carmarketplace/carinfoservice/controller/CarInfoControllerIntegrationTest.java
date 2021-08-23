package com.geekymon2.carmarketplace.carinfoservice.controller;

import com.geekymon2.carmarketplace.carinfoservice.models.CarMakeDto;
import com.geekymon2.carmarketplace.carinfoservice.models.CarModelDto;
import com.geekymon2.carmarketplace.carinfoservice.serviceimpl.CarInfoServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
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
public class CarInfoControllerIntegrationTest {
    private final CarInfoController controller;

    @Autowired
    public CarInfoControllerIntegrationTest(CarInfoServiceImpl service, ModelMapper mapper) {
        this.controller = new CarInfoController(service, mapper);
    }

    @Test
    @DisplayName("Test get car make by id.")
    void testGetCarMakeById() {
        CarMakeDto actual = controller.getCarMakeById(1L);
        CarMakeDto expected = new CarMakeDto(1L, "FORD", "USA");
        assertThat(expected.equals(actual)).isTrue();
    }

    @Test
    @DisplayName("Test get all car makes.")
    void testGetCarMakes() {
        List<CarMakeDto> actual = controller.getCarMakes();
        List<CarMakeDto> expected = generateValidMakeData();
        assertThat(expected.equals(actual)).isTrue();
    }

    @Test
    @DisplayName("Test invalid car makes count.")
    void getCarMakesCountInValidTest() {
        ResponseEntity<Long> actual = controller.getCarMakesCount();
        ResponseEntity<Long> expected = ResponseEntity.ok(999L);
        assertNotEquals(expected, actual);
    }

    @Test
    @DisplayName("Test valid car makes count.")
    void getCarMakesCountValidTest() {
        ResponseEntity<Long> actual = controller.getCarMakesCount();
        ResponseEntity<Long> expected = ResponseEntity.ok(2L);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test get all car models.")
    void testGetAllCarModels() {
        List<CarModelDto> actual = controller.getCarModelsByMakeAndType(null, null);
        List<CarModelDto> expected = generateValidModelsData();
        assertThat(expected.equals(actual)).isTrue();
    }

    @Test
    @DisplayName("Test get car model by id.")
    void testGetCarModelById() {
        CarModelDto actual = controller.getCarModelById(5L);
        CarModelDto expected = new CarModelDto(5L, "Audi A4 Sedan", "SEDAN");
        assertThat(expected.equals(actual)).isTrue();
    }

    @Test
    @DisplayName("Test get car models filter on make and type.")
    void testGetCarModelsByMakeAndType() {
        List<CarModelDto> actual = controller.getCarModelsByMakeAndType("FORD", "SUV");

        List<CarModelDto>  expected = new ArrayList<>();
        expected.add(new CarModelDto(4L, "Ford Puma", "SUV"));

        assertThat(expected.equals(actual)).isTrue();
    }

    @Test
    @DisplayName("Test get car models filter on make.")
    void testGetCarModelsByMake() {
        List<CarModelDto> actual = controller.getCarModelsByMakeAndType("FORD", null);

        List<CarModelDto>  expected = new ArrayList<>();
        expected.add(new CarModelDto(1L, "Ford Falcon", "SEDAN"));
        expected.add(new CarModelDto(2L, "Ford Focus Sedan", "SEDAN"));
        expected.add(new CarModelDto(3L, "Ford Focus Hatch", "HATCHBACK"));
        expected.add(new CarModelDto(4L, "Ford Puma", "SUV"));

        assertThat(expected.equals(actual)).isTrue();
    }

    @Test
    @DisplayName("Test get car models filter on type.")
    void testGetCarModelsByType() {
        List<CarModelDto> actual = controller.getCarModelsByMakeAndType(null, "SEDAN");

        List<CarModelDto>  expected = new ArrayList<>();
        expected.add(new CarModelDto(1L, "Ford Falcon", "SEDAN"));
        expected.add(new CarModelDto(2L, "Ford Focus Sedan", "SEDAN"));

        expected.add(new CarModelDto(5L, "Audi A4 Sedan", "SEDAN"));
        expected.add(new CarModelDto(6L, "Audi S4 Sedan", "SEDAN"));
        expected.add(new CarModelDto(7L, "Audi A6 Sedan", "SEDAN"));

        assertThat(expected.equals(actual)).isTrue();
    }

    //* This needs to match the make data in data.sql for the integration tests to be successful.
    private List<CarMakeDto> generateValidMakeData() {
        List<CarMakeDto> makes = new ArrayList<>();
        makes.add(new CarMakeDto(1L,"FORD","USA"));
        makes.add(new CarMakeDto(2L,"AUDI","Germany"));
        return makes;
    }

    //* This needs to match the make data in data.sql for the integration tests to be successful.
    private List<CarModelDto> generateValidModelsData() {
        List<CarModelDto> models = new ArrayList<>();

        models.add(new CarModelDto(1L, "Ford Falcon", "SEDAN"));
        models.add(new CarModelDto(2L, "Ford Focus Sedan", "SEDAN"));
        models.add(new CarModelDto(3L, "Ford Focus Hatch", "HATCHBACK"));
        models.add(new CarModelDto(4L, "Ford Puma", "SUV"));

        models.add(new CarModelDto(5L, "Audi A4 Sedan", "SEDAN"));
        models.add(new CarModelDto(6L, "Audi S4 Sedan", "SEDAN"));
        models.add(new CarModelDto(7L, "Audi A6 Sedan", "SEDAN"));
        models.add(new CarModelDto(8L, "Audi Q2", "SUV"));
        return models;
    }
}
