package com.atSistemas.atWeek.service.rate;

import com.atSistemas.atWeek.model.entity.Rate;

import java.util.List;
import java.util.Optional;

public interface RateService {

    /**
     * find a rate by id
     * @param id
     * @return
     */
    Optional<Rate> findOne(Integer id);

    /**
     * return list with all rate else empty list
     * @return
     */
    List<Rate> findAll();

    /**
     * create a new rate
     * @param rate
     * @return
     */
    Rate create(Rate rate);

    /**
     * update existing rate
     * @param rate
     * @return
     */
    Rate update(Rate rate);

    /**
     * delete existing rate
     * @param rate
     */
    void delete(Rate rate);
}
