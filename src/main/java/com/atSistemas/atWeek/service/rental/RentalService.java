package com.atSistemas.atWeek.service.rental;

import com.atSistemas.atWeek.model.entity.Rental;

import java.util.List;
import java.util.Optional;

public interface RentalService {

    /**
     * find a rental by id
     * @param id
     * @return
     */
    Optional<Rental> findOne(Integer id);

    /**
     * return list with all rental else empty list
     * @return
     */
    List<Rental> findAll();

    /**
     * create a new rental
     * @param rental
     * @return
     */
    Rental create(Rental rental);

    /**
     * update existing rental
     * @param rental
     * @return
     */
    Rental update(Rental rental);

    /**
     * delete existing rental
     * @param rental
     */
    void delete(Rental rental);
}
