package com.atSistemas.atWeek.service.rate;

import com.atSistemas.atWeek.dao.RateRepository;
import com.atSistemas.atWeek.exception.UnprocessableException;
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

    @Override
    public void validate(Rate rate) throws UnprocessableException {
        Optional.ofNullable(rate)
                .map(Rate::getStartDate)
                .orElseThrow(() -> new UnprocessableException("Start Date is required"));

        Optional.ofNullable(rate)
                .map(Rate::getEndDate)
                .orElseThrow(() -> new UnprocessableException("Start Date is required"));

        if(Optional.of(rate).get().getStartDate().isAfter(Optional.of(rate).get().getEndDate()))
            throw new UnprocessableException("End Date must be greather than Start Date");
    }

    @Override
    public Optional<Rate> findCurrentRate(Car car) {
        return repository.findTopByStartDateLessThanEqualAndEndDateGreaterThanAndCarsOrderByStartDateDesc(LocalDate.now(), LocalDate.now(), car);
    }

    @Override
    public Optional<Rate> findOne(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Rate> findAll() {
        return repository.findAll();
    }

    @Override
    public Rate create(Rate rate) {
        this.validate(rate);
        return repository.save(rate);
    }

    @Override
    public Rate update(Rate rate) {
        this.validate(rate);
        return repository.save(rate);
    }

    @Override
    public void delete(Rate rate) {
        repository.delete(rate);
    }
}
