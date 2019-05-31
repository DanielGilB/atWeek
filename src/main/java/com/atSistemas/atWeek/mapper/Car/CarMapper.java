package com.atSistemas.atWeek.mapper.Car;

import com.atSistemas.atWeek.model.dto.CarDTO;
import com.atSistemas.atWeek.model.entity.Car;

public interface CarMapper {

    /**
     * map CarDTO to Car entity
     * @param dto
     * @return
     */
    Car map(CarDTO dto);

    /**
     * map Car entity to CarDTO
     * @param car
     * @return
     */
    CarDTO map(Car car);
}
