package com.atSistemas.atWeek.dao;

import com.atSistemas.atWeek.model.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
}
