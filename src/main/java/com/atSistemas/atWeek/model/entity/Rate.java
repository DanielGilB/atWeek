package com.atSistemas.atWeek.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idRate;

    private LocalDate start_at;
    private LocalDate end_at;

    @Column(name="Price", columnDefinition="Decimal(10,2) default '100.00'")
    private Double price;
}
