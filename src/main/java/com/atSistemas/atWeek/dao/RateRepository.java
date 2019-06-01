package com.atSistemas.atWeek.dao;

import com.atSistemas.atWeek.model.entity.Car;
import com.atSistemas.atWeek.model.entity.Rate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface RateRepository extends JpaRepository<Rate, Integer> {

    Optional<Rate> findTopByStartDateLessThanEqualAndCarsOrderByStartDateDesc(LocalDate date, Car car);

}
