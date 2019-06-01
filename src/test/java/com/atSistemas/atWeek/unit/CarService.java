package com.atSistemas.atWeek.unit;

import com.atSistemas.atWeek.dao.CarRepository;
import com.atSistemas.atWeek.exception.ConflictException;
import com.atSistemas.atWeek.model.entity.Car;
import com.atSistemas.atWeek.service.car.CarServiceImp;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class CarService {

    @InjectMocks
    private CarServiceImp service;

    @Mock
    private CarRepository repository;

    @Test
    public void whenCreateCarWithExistingCarPlateThenShouldReturnConflictExceptionAndShouldNotStoredNewCar()
        throws ConflictException{

        final String plate = "123ABC";
        final Car carWithUniqueCarPlate = new Car();
        final Car carWithExistingCarPlate = new Car();

        carWithUniqueCarPlate.setCarPlate(plate);
        carWithExistingCarPlate.setCarPlate(plate);

        Mockito.when(service.create(carWithUniqueCarPlate)).thenReturn(carWithUniqueCarPlate);
        Mockito.when(service.create(carWithExistingCarPlate)).thenThrow(ConflictException.class);

        Mockito.verify(repository, Mockito.never()).save(carWithExistingCarPlate);
    }

    @Test
    public void whenSearchExistingCarWithExistingPlateShouldReturnCar(){

        final String searchedCarPlate = "123ABC";
        final String notSearchedCarPlate = "ABC123";

        final Car searchedCar = new Car();
        final Car notSearchedCar = new Car();

        searchedCar.setCarPlate(searchedCarPlate);
        notSearchedCar.setCarPlate(notSearchedCarPlate);

        Mockito.when(service.search(searchedCarPlate)).thenReturn(Optional.of(searchedCar));

        Assert.assertNotEquals(searchedCar, notSearchedCar);
        Assert.assertNotEquals(searchedCarPlate, notSearchedCarPlate);
        Assert.assertNotNull(searchedCarPlate);
    }

}
