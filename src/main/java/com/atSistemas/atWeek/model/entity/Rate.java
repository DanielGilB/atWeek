package com.atSistemas.atWeek.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String startDate;
    private String endDate;

    @Column(name="Price", columnDefinition="Decimal(10,2) default '0.00'")
    private Double price;


    @ManyToMany(fetch = FetchType.LAZY)
    private List<Car> cars = new ArrayList<>();
}
