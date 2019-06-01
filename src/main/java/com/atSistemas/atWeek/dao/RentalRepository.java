package com.atSistemas.atWeek.dao;

import com.atSistemas.atWeek.model.entity.Car;
import com.atSistemas.atWeek.model.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;


public interface RentalRepository extends JpaRepository<Rental, Integer> {

    Optional<Rental> findFirstByStartDateBetweenAndCar(LocalDate startDate, LocalDate endDate, Car car);

    Optional<Rental> findFirstByEndDateBetweenAndCar(LocalDate startDate, LocalDate endDate, Car car);
}
