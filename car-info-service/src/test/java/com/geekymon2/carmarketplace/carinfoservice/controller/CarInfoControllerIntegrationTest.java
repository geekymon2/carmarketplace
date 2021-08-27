package com.geekymon2.carmarketplace.carinfoservice.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.geekymon2.carmarketplace.carinfoservice.entities.CarModelType;
import com.geekymon2.carmarketplace.carinfoservice.exception.InvalidParameterException;
import com.geekymon2.carmarketplace.carinfoservice.exception.RecordNotFoundException;
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
    @DisplayName("Test get all car makes.")
    void testGetCarMakes() {
        List<CarMakeDto> actual = controller.getCarMakes();
        List<CarMakeDto> expected = generateValidMakeData();
        assertThat(expected.equals(actual)).isTrue();
    }

    @Test
    @DisplayName("Test get car make by id.")
    void testGetCarMakeById() {
        CarMakeDto actual = controller.getCarMakeById(1L);
        CarMakeDto expected = new CarMakeDto(1L, "FORD", "USA");
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
    @DisplayName("Test valid car models count.")
    void getCarModelsCountValidTest() {
        ResponseEntity<Long> actual = controller.getCarModelsCount();
        ResponseEntity<Long> expected = ResponseEntity.ok(8L);
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
    @DisplayName("Test get car models filter on make and type.")
    void testGetCarModelsByMakeAndType() {
        List<CarModelDto> actual = controller.getCarModelsByMakeAndType("FORD", "SUV");
        List<CarModelDto>  expected = new ArrayList<>();
        expected.add(new CarModelDto(4L, "Ford Puma", "SUV"));

        assertEquals(actual.size(), expected.size(), "count of CarModels should match.");
        for (int i=0; i<expected.size();i++)
        {
            assertTrue(isModelDtoEqual(expected.get(i), actual.get(i)));
        }
    }

    @Test
    @DisplayName("Test get car models filter on invalid make.")
    void testGetCarModelsByInvalidMake() {
        assertThrows(InvalidParameterException.class, () -> {
            controller.getCarModelsByMakeAndType("XXXX", null);
        });
    }    

    @Test
    @DisplayName("Test get car models filter on invalid type.")
    void testGetCarModelsByInvalidType() {
        assertThrows(InvalidParameterException.class, () -> {
            controller.getCarModelsByMakeAndType("FORD", "XXXX");
        });
    }

    @Test
    @DisplayName("Test get car make filter on invalid id.")
    void testGetCarMakeByInvalidID() {
        assertThrows(RecordNotFoundException.class, () -> {
            controller.getCarMakeById(99999999L);
        });
    }    

    @Test
    @DisplayName("Test get car model filter on invalid id.")
    void testGetCarModelByInvalidID() {
        assertThrows(RecordNotFoundException.class, () -> {
            controller.getCarModelById(99999999L);
        });
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

        assertEquals(actual.size(), expected.size(), "count of CarModels should match.");
        for (int i=0; i<expected.size();i++)
        {
            assertTrue(isModelDtoEqual(expected.get(i), actual.get(i)));
        }
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

        assertEquals(actual.size(), expected.size(), "count of CarModels should match.");
        for (int i=0; i<expected.size();i++)
        {
            assertTrue(isModelDtoEqual(expected.get(i), actual.get(i)));
        }
    }

    @Test
    @DisplayName("Test get car model by id.")
    void testGetCarModelById() {
        CarModelDto actual = controller.getCarModelById(5L);
        CarModelDto expected = new CarModelDto(5L, "Audi A4 Sedan", "SEDAN");
        assertTrue(isModelDtoEqual(expected, actual));
    }

    @Test
    @DisplayName("Test valid car model types.")
    void getCarModelTypesTest() {
        List<CarModelType> actual = controller.getCarModelTypes();
        List<CarModelType> expected = Arrays.stream(CarModelType.values()).collect(Collectors.toList());
        assertEquals(expected, actual);
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

    private Boolean isModelDtoEqual(CarModelDto actual, CarModelDto expected) {
        return ((actual.getName().equals(expected.getName())) &&
                (actual.getId().equals(expected.getId())) &&
                (actual.getType().equals(expected.getType())));
    }

    @Test
    void getCarModelsCount() {
    }

    @Test
    void getCarModelTypes() {
    }
}
