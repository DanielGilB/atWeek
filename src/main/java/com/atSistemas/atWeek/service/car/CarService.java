package com.atSistemas.atWeek.service.car;

import com.atSistemas.atWeek.model.entity.Car;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface CarService {

    /**
     * find a car by id
     * @param id
     * @return car with id if exists
     */
    Optional<Car> findOne(Integer id);

    /**
     * return list with all cars else empty list
     * @return list with all exsiting cars
     */
    List<Car> findAll();

    /**
     * create a new car
     * @param car
     * @return car created
     */
    Car create(Car car);

    /**
     * update existing car
     * @param car
     * @return car updated
     */
    Car update(Car car);

    /**
     * delete existing car
     * @param car
     */
    void delete(Car car);
}
