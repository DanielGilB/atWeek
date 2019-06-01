package com.atSistemas.atWeek.service.rental;

import com.atSistemas.atWeek.exception.ConflictException;
import com.atSistemas.atWeek.exception.NotFoundException;
import com.atSistemas.atWeek.model.entity.Car;
import com.atSistemas.atWeek.model.entity.Rate;
import com.atSistemas.atWeek.model.entity.Rental;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RentalService {

    /**
     * create a price to a rent
     * @param rental
     * @return
     */
   // Double price(Rental rental);

    /**
     * find current rate from a car
     * @param car
     * @return current rate
     * @throws NotFoundException does not exist rate for this date
     */
    //Optional<Rate> currentRate(Car car) throws NotFoundException;

    /**
     * validate if possible to create a rental
     * @param rental
     * @throws NotFoundException if client or car does not exist
     * @throws ConflictException if the car is not available
     */
    void validate(Rental rental) throws NotFoundException, ConflictException;

    /**
     * check is a car is ordered between startDate and endDate
     * @param car
     * @param startDate
     * @param endDate
     * @return if car is ordered between dates
     */
    boolean isCarOrderedBetweenDates(Car car, LocalDate startDate, LocalDate endDate);

    /**
     * find a rental by id
     * @param id
     * @return with id if exists
     */
    Optional<Rental> findOne(Integer id);

    /**
     * return list with all rental else empty list
     * @return list with all exsiting rentals
     */
    List<Rental> findAll();

    /**
     * create a new rental
     * @param rental
     * @return car created
     */
    Rental create(Rental rental);

    /**
     * update existing rental
     * @param rental
     * @return rental updated
     */
    Rental update(Rental rental);

    /**
     * delete existing rental
     * @param rental
     */
    void delete(Rental rental);
}
