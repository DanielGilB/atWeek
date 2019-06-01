package com.atSistemas.atWeek.service.rateCar;


import com.atSistemas.atWeek.exception.NotFoundException;
import com.atSistemas.atWeek.model.entity.Car;
import com.atSistemas.atWeek.model.entity.Rate;
import com.atSistemas.atWeek.service.car.CarServiceImp;
import com.atSistemas.atWeek.service.rate.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RateCarServiceImp implements RateCarService{

    @Autowired
    private RateService rateService;

    @Autowired
    private CarServiceImp carService;

    @Override
    public void associateRateCar(Integer idRate, Integer idCar) throws NotFoundException{

        Optional<Rate> rate = rateService.findOne(idRate);
        if(!rate.isPresent())
            throw new NotFoundException("This rate doest not exist");

        Optional<Car> car = carService.findOne(idCar);
        if(!car.isPresent())
            throw new NotFoundException("This car doest not exist");

        car.get().setRate(rate.get());
        rate.get().setCar(car.get());

        carService.update(car.get());
        rateService.update(rate.get());
    }
}
