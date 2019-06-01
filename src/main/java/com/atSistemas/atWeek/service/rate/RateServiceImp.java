package com.atSistemas.atWeek.service.rate;

import com.atSistemas.atWeek.dao.RateRepository;
import com.atSistemas.atWeek.model.entity.Car;
import com.atSistemas.atWeek.model.entity.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class RateServiceImp implements RateService{

    @Autowired
    private RateRepository repository;

    /*
    @Override
    public Optional<Rate> findCurrentRate(Car car) {
        return repository.findFirstByStartDateNearAndCar(LocalDate.now(), car);
    }
    */

    @Override
    public Optional<Rate> findOne(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Rate> findAll() {
        return repository.findAll();
    }

    @Override
    public Rate create(Rate client) {
        return repository.save(client);
    }

    @Override
    public Rate update(Rate client) {
        return repository.save(client);
    }

    @Override
    public void delete(Rate client) {
        repository.delete(client);
    }
}
