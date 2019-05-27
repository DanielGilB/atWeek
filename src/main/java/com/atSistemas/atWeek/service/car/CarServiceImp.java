package com.atSistemas.atWeek.service.car;

import com.atSistemas.atWeek.dao.car.CarRepository;
import com.atSistemas.atWeek.model.entity.Car;
import com.atSistemas.atWeek.service.CrudServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class CarServiceImp extends CrudServiceImp<Car, Integer> implements CarService{
/*
    @Autowired
    private CarRepository repository;

    public CarServiceImp(CarRepository repository){
        this.repository = repository;
    }
 */
}
