package com.atSistemas.atWeek.model.entity;

import com.atSistemas.atWeek.model.entity.Car;
import com.atSistemas.atWeek.model.entity.Client;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private LocalDate start_at;
    private LocalDate end_at;

    @Column(columnDefinition="Decimal(10,2) default '0.00'")
    private Double price;

    @ManyToOne
    private Car car;

    @ManyToOne
    private Client client;
}
