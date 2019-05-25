package com.atSistemas.atWeek.model.entity;

import com.atSistemas.atWeek.model.entity.Car;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private LocalDate start_at;
    private LocalDate end_at;

    @Column(name="Price", columnDefinition="Decimal(10,2) default '0.00'")
    private Double price;


    @ManyToMany
    private List<Car> cars = new ArrayList<>();
}
