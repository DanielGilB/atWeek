package com.atSistemas.atWeek.model.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @CreationTimestamp
    private LocalDate createdDate;

    private LocalDate startDate;
    private LocalDate endDate;

    @Column(columnDefinition="Decimal(10,2) default '0.00'")
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Car car;

    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;
}
