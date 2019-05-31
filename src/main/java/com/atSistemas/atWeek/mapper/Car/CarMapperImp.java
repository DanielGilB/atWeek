package com.atSistemas.atWeek.mapper.Car;

import com.atSistemas.atWeek.model.dto.CarDTO;
import com.atSistemas.atWeek.model.entity.Car;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CarMapperImp implements CarMapper{

    @Override
    public Car map(CarDTO dto) {

        Car car = new Car();
        Optional<CarDTO> carDTO = Optional.ofNullable(dto);

        carDTO.map(CarDTO::getId).ifPresent(car::setId);
        carDTO.map(CarDTO::getCarPlate).ifPresent(car::setCarPlate);
        carDTO.map(CarDTO::getRegistrationYear).ifPresent(date ->
                { try { car.setRegistrationYear(Integer.valueOf(date)); }
                catch (NumberFormatException e){ throw e; }});

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

    @Override
    public List<CarDTO> map(List<Car> cars) {

        return cars.stream()
                    .map(this::map)
                    .collect(Collectors.toList());
    }
}
