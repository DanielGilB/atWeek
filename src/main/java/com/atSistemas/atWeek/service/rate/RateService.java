package com.atSistemas.atWeek.service.rate;

import com.atSistemas.atWeek.exception.UnprocessableException;
import com.atSistemas.atWeek.model.entity.Car;
import com.atSistemas.atWeek.model.entity.Rate;

import java.util.List;
import java.util.Optional;

public interface RateService {

    /**
     * validate required field and corrects dates
     * @param rate
     * @throws UnprocessableException startDate < endDate or empty field
     */
    void validate(Rate rate) throws UnprocessableException;

    /**
     * find car rate from today
     * @param car
     * @return car rate from today
     */
    Optional<Rate> findCurrentRate(Car car);

    /**
     * find a rate by id
     * @param id
     * @return with id if exists
     */
    Optional<Rate> findOne(Integer id);

    /**
     * return list with all rate else empty list
     * @return list with all exsiting rates
     */
    List<Rate> findAll();

    /**
     * create a new rate
     * @param rate
     * @return car created
     */
    Rate create(Rate rate);

    /**
     * update existing rate
     * @param rate
     * @return rate updated
     */
    Rate update(Rate rate);

    /**
     * delete existing rate
     * @param rate
     */
    void delete(Rate rate);

}
