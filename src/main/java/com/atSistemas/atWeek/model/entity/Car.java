package com.atSistemas.atWeek.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String carPlate;
    private String registrationYear;

    @ManyToMany(mappedBy = "cars", fetch = FetchType.LAZY)
    private Set<Rate> rates = new HashSet<>();

    @OneToMany(mappedBy = "car", fetch = FetchType.LAZY)
    private List<Rental> rentals = new ArrayList<>();
}
