package com.geekymon2.carmarketplace.carinfoservice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="model")
public class CarModel {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name="make_id", nullable=false)
    private CarMake make;

    public CarModel() {
    }

    public CarModel(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CarModel(Long id, String name, CarMake make) {
        this.id = id;
        this.name = name;
        this.make = make;
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

}
