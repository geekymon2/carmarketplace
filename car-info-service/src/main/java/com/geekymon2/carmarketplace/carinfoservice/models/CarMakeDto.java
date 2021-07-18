package com.geekymon2.carmarketplace.carinfoservice.models;

import java.util.Objects;

public class CarMakeDto {
    String name;
    String countryOfOrigin;

    public CarMakeDto(String name, String countryOfOrigin) {
        this.name = name;
        this.countryOfOrigin = countryOfOrigin;
    }

    public CarMakeDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarMakeDto carMakeDto = (CarMakeDto) o;
        return name.equals(carMakeDto.name) && countryOfOrigin.equals(carMakeDto.countryOfOrigin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, countryOfOrigin);
    }
}
