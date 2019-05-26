package com.atSistemas.atWeek.service.car;


import com.atSistemas.atWeek.dao.car.CarRepository;
import com.atSistemas.atWeek.model.entity.Car;
import com.atSistemas.atWeek.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface CarService extends CrudService<Car, Integer> {

}
