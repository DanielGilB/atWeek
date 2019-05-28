package com.atSistemas.atWeek.controller.api;

import com.atSistemas.atWeek.controller.CrudController;
import com.atSistemas.atWeek.model.entity.Car;
import com.atSistemas.atWeek.service.car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarController extends CrudController<Car, Integer>{
/*
    @Autowired
    private CarService service;

    public CarController(CarService service){
        super(service);
    }

 */
}
