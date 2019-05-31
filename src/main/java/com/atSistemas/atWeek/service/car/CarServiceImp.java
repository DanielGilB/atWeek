package com.atSistemas.atWeek.service.car;

import com.atSistemas.atWeek.dao.CarRepository;
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
    public Optional<Car> findOne(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Car> findAll() {
        return null;
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
