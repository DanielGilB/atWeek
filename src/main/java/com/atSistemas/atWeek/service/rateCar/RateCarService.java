package com.atSistemas.atWeek.service.rateCar;

import com.atSistemas.atWeek.exception.NotFoundException;

public interface RateCarService {

    /**
     * associate rate to car
     * @param idRate
     * @param idCar
     * @throws NotFoundException rate or car doesnt exist
     */
    void associateRateCar(Integer idRate, Integer idCar) throws NotFoundException;
}
