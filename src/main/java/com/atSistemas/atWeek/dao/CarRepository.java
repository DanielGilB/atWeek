package com.atSistemas.atWeek.dao;

import com.atSistemas.atWeek.model.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
