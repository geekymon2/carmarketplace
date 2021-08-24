package com.geekymon2.carmarketplace.carinfoservice.entities;

import lombok.*;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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


    public CarMake(Long id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }
}
