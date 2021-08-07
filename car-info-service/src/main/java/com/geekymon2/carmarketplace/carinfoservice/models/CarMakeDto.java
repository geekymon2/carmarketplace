package com.geekymon2.carmarketplace.carinfoservice.models;

import java.util.Objects;

public class CarMakeDto {
    Long id;
    String name;
    String country;

    public CarMakeDto() {
        super();
    }

    public CarMakeDto(Long id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public CarMakeDto(String name, String country) {
        this.name = name;
        this.country = country;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String countryOfOrigin) {
        this.country = countryOfOrigin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarMakeDto carMakeDto = (CarMakeDto) o;
        return name.equals(carMakeDto.name) && country.equals(carMakeDto.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country);
    }
}
