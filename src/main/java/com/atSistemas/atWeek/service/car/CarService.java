package com.atSistemas.atWeek.service.car;

import com.atSistemas.atWeek.exception.ConflictException;
import com.atSistemas.atWeek.exception.UnprocessableException;
import com.atSistemas.atWeek.model.entity.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    /**
     *  validate unique Car Plate and requireds field to create a car
     * @param car
     * @throws ConflictException already exist a car with Car Plate
     * @throws UnprocessableException missing required field
     */
    void validate(Car car) throws ConflictException, UnprocessableException;

    /**
     * Search a car by CarPlate
     * @param carPlate
     * @return car with {carPlate} if exists
     */
    Optional<Car> search(String carPlate);

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
