package com.atSistemas.atWeek.service.car;

import com.atSistemas.atWeek.dao.CarRepository;
import com.atSistemas.atWeek.dao.RentalRepository;
import com.atSistemas.atWeek.model.entity.Car;
import com.atSistemas.atWeek.service.rental.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImp implements CarService{

    @Autowired
    private CarRepository repository;

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
        return repository.save(car);
    }

    @Override
    public Car update(Car car) {
        return repository.save(car);
    }

    @Override
    public void delete(Car car) {
        repository.delete(car);
    }
}
