package com.atSistemas.atWeek.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String carPlate;
    //FIXME: String(4) with regex
    private Integer registrationYear;

    @OneToMany(mappedBy = "car", fetch = FetchType.LAZY)
    private Set<Rental> rentals = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "cars", fetch = FetchType.LAZY)
    private Set<Rate> rates = new HashSet<>();

    public void setRate(Rate rate){
        rates.add(rate);
    }
}
