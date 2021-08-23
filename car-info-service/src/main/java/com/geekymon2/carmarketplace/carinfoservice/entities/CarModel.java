package com.geekymon2.carmarketplace.carinfoservice.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity(name="model")
public class CarModel {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private CarModelType type;
    @ManyToOne
    @JoinColumn(name="make_id", nullable=false)
    private CarMake make;

    public CarModel() {
    }

    public CarModel(Long id, String name, CarMake make, CarModelType type) {
        this.id = id;
        this.name = name;
        this.make = make;
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

    public CarMake getMake() {
        return make;
    }

    public void setMake(CarMake make) {
        this.make = make;
    }

    public CarModelType getModelType() {
        return type;
    }

    public void setModelType(CarModelType type) {
        this.type = type;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarModel carModel = (CarModel) o;
        return Objects.equals(id, carModel.id) && Objects.equals(name, carModel.name) && type == carModel.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type);
    }
}
