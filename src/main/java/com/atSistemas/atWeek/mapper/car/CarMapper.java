package com.atSistemas.atWeek.mapper.car;

import com.atSistemas.atWeek.model.dto.CarDTO;
import com.atSistemas.atWeek.model.entity.Car;

import java.util.List;

public interface CarMapper {

    /**
     * map CarDto to car entity
     * @param dto
     * @return
     * @throws NumberFormatException
     */
    Car map(CarDTO dto) throws NumberFormatException;

    /**
     * map car entity to CarDTO
     * @param car
     * @return
     */
    CarDTO map(Car car);

    /**
     * map a list of Cars to list of CarDTOs
     * @param cars
     * @return
     */
    List<CarDTO> map(List<Car> cars);
}
