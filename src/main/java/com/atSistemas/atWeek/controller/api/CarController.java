package com.atSistemas.atWeek.controller.api;

import com.atSistemas.atWeek.exception.ConflictException;
import com.atSistemas.atWeek.exception.NotFoundException;
import com.atSistemas.atWeek.exception.UnprocessableException;
import com.atSistemas.atWeek.mapper.car.CarMapper;
import com.atSistemas.atWeek.model.dto.CarDTO;
import com.atSistemas.atWeek.model.entity.Car;
import com.atSistemas.atWeek.service.car.CarServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/car")
public class CarController{

    @Autowired
    private CarServiceImp service;

    @Autowired
    private CarMapper mapper;

    @GetMapping("/profitable/{startDate}/{endDate}")
    public CarDTO profitable(@PathVariable("startDate") String startDate,
                             @PathVariable("endDate") String endDate){

       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-[uuuu][uu]");

        try {
            LocalDate start = LocalDate.parse(startDate, formatter);
            LocalDate end = LocalDate.parse(endDate, formatter);

            Optional<Car> car = service.profitable(start, end);

            if(!car.isPresent())
                throw new NotFoundException("There are no rentals between these dates");
            else
                return mapper.map(car.get());
        }
        catch (DateTimeParseException e) { throw e; }
    }

    @GetMapping("plate/{carPlate}")
    public CarDTO search(@PathVariable("carPlate") String carPlate){
        return Optional.ofNullable(carPlate)
                .flatMap(service::search)
                .map(mapper::map)
                .orElseThrow(() -> new NotFoundException("There is no car with this Car Plate"));
    }

    @GetMapping("/{id}")
    public CarDTO findOne(@PathVariable("id") Integer id){
        return Optional.ofNullable(id)
                .flatMap(service::findOne)
                .map(mapper::map)
                .orElseThrow(() -> new NotFoundException("This car does not exist"));
    }

    @GetMapping
    public List<CarDTO> findAll(){
        //TODO: paginar
        return mapper.map(service.findAll());
    }

    @PostMapping
    public CarDTO create(@RequestBody CarDTO dto) throws ConflictException, UnprocessableException {
        return Optional.ofNullable(dto)
                .map(mapper::map)
                .map(service::create)
                .map(mapper::map)
                .orElseThrow(() -> new NotFoundException("This car does not exist"));
    }

    @PutMapping
    public CarDTO update(@RequestBody CarDTO dto) throws ConflictException, UnprocessableException{
        return Optional.ofNullable(dto)
                .map(mapper::map)
                .map(service::update)
                .map(mapper::map)
                .orElseThrow(() -> new NotFoundException("This car does not exist"));
    }

    @DeleteMapping
    public void delete(@RequestBody CarDTO dto){
        /*
        Optional.ofNullable(dto)
            .map(mapper::map)
                 .ifPresent(service::delete); // hasta java 9 no hay ifPresentorElse :(
         */
        Optional<Car> existsCar = service.findOne(dto.getId());
        if(!existsCar.isPresent()) throw new NotFoundException("This car does not exist");
        else service.delete(mapper.map(dto));
    }

}
