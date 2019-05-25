package com.atSistemas.atWeek.controller.api;

import com.atSistemas.atWeek.controller.CrudController;
import com.atSistemas.atWeek.dao.car.CarRepository;
import com.atSistemas.atWeek.model.entity.Car;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarController extends CrudController<Car, CarRepository> {
}
