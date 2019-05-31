package com.atSistemas.atWeek.mapper.Car;

import com.atSistemas.atWeek.model.dto.CarDTO;
import com.atSistemas.atWeek.model.entity.Car;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

@Component
public class CarMapperImp implements CarMapper{

    @Override
    public Car map(CarDTO dto) {

        Car car = new Car();
        Optional<CarDTO> carDTO = Optional.ofNullable(dto);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        carDTO.map(CarDTO::getId).ifPresent(car::setId);
        carDTO.map(CarDTO::getCarPlate).ifPresent(car::setCarPlate);
        carDTO.map(CarDTO::getRegistrationYear).ifPresent(date ->
                { try { car.setRegistrationYear(LocalDate.parse(date, formatter)); }
                    catch (DateTimeParseException e){ throw e; }
                });

        return car;
    }

    @Override
    public CarDTO map(Car car) {

        CarDTO dto = new CarDTO();
        Optional<Car> carEntity = Optional.ofNullable(car);

        carEntity.map(Car::getId).ifPresent(dto::setId);
        carEntity.map(Car::getCarPlate).ifPresent(dto::setCarPlate);
        carEntity.map(Car::getRegistrationYear).ifPresent(date ->
                { dto.setRegistrationYear(date.toString()); } );

        return dto;
    }
}
