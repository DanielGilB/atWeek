package com.atSistemas.atWeek.mapper.Car;

import com.atSistemas.atWeek.model.dto.CarDTO;
import com.atSistemas.atWeek.model.entity.Car;

import java.util.List;

public interface CarMapper {

    /**
     * map CarDto to Car entity
     * @param dto
     * @return
     * @throws NumberFormatException
     */
    Car map(CarDTO dto) throws NumberFormatException;

    /**
     * map Car entity to CarDTO
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
