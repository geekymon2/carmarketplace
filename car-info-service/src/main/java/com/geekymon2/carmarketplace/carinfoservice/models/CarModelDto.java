package com.geekymon2.carmarketplace.carinfoservice.models;

import java.util.Objects;

public class CarModelDto {
    Long id;
    String name;
    String type;

    public CarModelDto() {
        super();
    }

    public CarModelDto(String name) {
        this.name = name;
    }

    public CarModelDto(Long id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
