package com.geekymon2.carmarketplace.carinfoservice.models;

import java.util.Objects;

public class CarModel {
    String name;

    public CarModel(String name) {
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
        CarModel carModel = (CarModel) o;
        return name.equals(carModel.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
