package com.atSistemas.atWeek.dao.car;

import com.atSistemas.atWeek.dao.CrudRepository;
import com.atSistemas.atWeek.model.entity.Car;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {

}
