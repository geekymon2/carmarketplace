package com.geekymon2.carmarketplace.carinfoservice.entities;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "make")
public class CarMake {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;
    private String country;
    @OneToMany(mappedBy = "make")
    private Set<CarModel> models;

    public CarMake() {
    }

    public CarMake(String name) {
        this.name = name;
    }

    public CarMake(Long id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public CarMake(Long id, String name, String country, Set<CarModel> models) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.models = models;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<CarModel> getModels() {
        return models;
    }

    public void setModels(Set<CarModel> models) {
        this.models = models;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarMake carMake = (CarMake) o;
        return id.equals(carMake.id) && name.equals(carMake.name) && country.equals(carMake.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country);
    }
}
