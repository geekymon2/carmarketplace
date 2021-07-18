package com.geekymon2.carmarketplace.carinfoservice.models;

import java.util.Objects;

public class CarMake {
    String name;
    String countryOfOrigin;

    public CarMake(String name, String countryOfOrigin) {
        this.name = name;
        this.countryOfOrigin = countryOfOrigin;
    }

    public CarMake(String name) {
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
        CarMake carMake = (CarMake) o;
        return name.equals(carMake.name) && countryOfOrigin.equals(carMake.countryOfOrigin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, countryOfOrigin);
    }
}
