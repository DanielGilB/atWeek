package com.atSistemas.atWeek.controller.api;

import com.atSistemas.atWeek.dao.CarRepository;
import com.atSistemas.atWeek.dao.RentalRepository;
import com.atSistemas.atWeek.exception.ConflictException;
import com.atSistemas.atWeek.exception.NotFoundException;
import com.atSistemas.atWeek.exception.UnprocessableException;
import com.atSistemas.atWeek.mapper.car.CarMapper;
import com.atSistemas.atWeek.model.dto.CarDTO;
import com.atSistemas.atWeek.model.entity.Car;
import com.atSistemas.atWeek.service.car.CarServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/car")
public class CarController{

    @Autowired
    private CarServiceImp service;

    @Autowired
    private CarMapper mapper;


    @Autowired
    private CarRepository carRepository;
    @Autowired
    private RentalRepository rentalRepository;

    @GetMapping("/profitable")
    public List<Integer> profitable(){
        LocalDate startDate = LocalDate.of(2019, 05, 10);
        LocalDate endDate = LocalDate.of(2019, 07, 10);

        Pageable pageable = PageRequest.of(0,1); // limit 1
       // List<Integer> result = carRepository.findTopProfitableCar(startDate, endDate, pageable);

        return service.profitable(startDate, endDate, pageable);
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
