package com.atSistemas.atWeek.dao;

import com.atSistemas.atWeek.model.entity.Rate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RateRepository extends JpaRepository<Rate, Integer> {
}
