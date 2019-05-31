package com.atSistemas.atWeek.service.car;

import com.atSistemas.atWeek.model.entity.Car;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface CarService {

    /**
     * find a car by id
     * @param id
     * @return
     */
    Optional<Car> findOne(Integer id);

    /**
     * return list with all cars else empty list
     * @return
     */
    List<Car> findAll();

    /**
     * create a new car
     * @param car
     * @return
     */
    Car create(Car car);

    /**
     * update existing car
     * @param car
     * @return
     */
    Car update(Car car);

    /**
     * delete existing car
     * @param car
     */
    void delete(Car car);
}
