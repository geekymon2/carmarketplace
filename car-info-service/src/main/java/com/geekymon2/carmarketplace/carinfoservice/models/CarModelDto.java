package com.geekymon2.carmarketplace.carinfoservice.models;

import java.util.Objects;

public class CarModelDto {
    String name;

    public CarModelDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarModelDto carModelDto = (CarModelDto) o;
        return name.equals(carModelDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
