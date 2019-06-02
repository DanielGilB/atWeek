package com.atSistemas.atWeek.controller.api;

import com.atSistemas.atWeek.service.rateCar.RateCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateCarController {

    @Autowired
    private RateCarService service;

    @GetMapping("/rate/{idRate}/car/{idCar}")
    public void setRateToCar(@PathVariable("idRate") Integer idRate,
                               @PathVariable("idCar") Integer idCar){
        service.associateRateCar(idRate, idCar);
    }

    @GetMapping("/car/{idCar}/rate/{idRate}")
    public void setCarToRare(@PathVariable("idCar") Integer idCar,
                             @PathVariable("idRate") Integer idRate){
        service.associateRateCar(idRate, idCar);
    }
}
