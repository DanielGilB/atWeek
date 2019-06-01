package com.atSistemas.atWeek.service.car;

import com.atSistemas.atWeek.dao.CarRepository;
import com.atSistemas.atWeek.exception.ConflictException;
import com.atSistemas.atWeek.exception.UnprocessableException;
import com.atSistemas.atWeek.model.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImp implements CarService{

    @Autowired
    private CarRepository repository;

    @Override
    public void validate(Car car) throws ConflictException, UnprocessableException {

        Optional.ofNullable(car)
                .map(Car::getCarPlate)
                .orElseThrow(() -> new UnprocessableException("Car Plate is field required"));

        Optional.ofNullable(car)
                .map(Car::getCarPlate)
                .flatMap(this::search)
                .ifPresent(c -> {
                    if(!c.getId().equals(car.getId())) // checks if is the same car
                        throw new ConflictException("There is already a car with that plate");
                });
    }

    @Override
    public Optional<Car> search(String carPlate) {
        return repository.findByCarPlate(carPlate);
    }

    @Override
    public Optional<Car> findOne(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Car> findAll() {
        return repository.findAll();
    }

    @Override
    public Car create(Car car) {
        this.validate(car);
        return repository.save(car);
    }

    @Override
    public Car update(Car car) {
       // this.validate(car);
        return repository.save(car);
    }

    @Override
    public void delete(Car car) {
        repository.delete(car);
    }
}
