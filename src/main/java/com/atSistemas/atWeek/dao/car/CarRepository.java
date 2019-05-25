package com.atSistemas.atWeek.dao.car;

import com.atSistemas.atWeek.dao.CrudRepository;
import com.atSistemas.atWeek.model.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class CarRepository implements CrudRepository<Car, Integer> {

}