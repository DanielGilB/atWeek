package com.atSistemas.atWeek.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String dni;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Rental> rentals = new HashSet<>();
}
