package com.atSistemas.atWeek.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private LocalDate startDate;
    private LocalDate endDate;

    @Column(name="Price", columnDefinition="Decimal(10,2) default '0.00'")
    private Double price;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Car> cars = new HashSet<>();
}
