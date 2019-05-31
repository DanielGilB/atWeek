package com.atSistemas.atWeek.controller.api;

import com.atSistemas.atWeek.mapper.Car.CarMapper;
import com.atSistemas.atWeek.model.dto.CarDTO;
import com.atSistemas.atWeek.model.entity.Car;
import com.atSistemas.atWeek.service.car.CarServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.ValidationException;
import java.util.Optional;

@RestController
@RequestMapping("/car")
public class CarController{

    @Autowired
    private CarServiceImp service;

    @Autowired
    private CarMapper mapper;

    @GetMapping("/{id}")
    public CarDTO findOne(@PathVariable("id") Integer id){
        return Optional.ofNullable(id)
                .flatMap(service::findOne)
                .map(mapper::map)
                .orElseThrow(() -> new ValidationException("This car not exits"));
    }

    @PostMapping
    public CarDTO create(@RequestBody CarDTO dto){
        //TODO: validar que no exista ya un coche con misma matricula
        return Optional.ofNullable(dto)
                .map(mapper::map)
                .map(service::create)
                .map(mapper::map)
                .orElseThrow(() -> new ValidationException("FAIL!!"));
    }

    @PutMapping
    public CarDTO update(@RequestBody CarDTO dto){
        return Optional.ofNullable(dto)
                .map(mapper::map)
                .map(service::update)
                .map(mapper::map)
                .orElseThrow(() -> new ValidationException("This car not exits"));
    }

}
