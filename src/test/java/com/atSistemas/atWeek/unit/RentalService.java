package com.atSistemas.atWeek.unit;

import com.atSistemas.atWeek.model.entity.Car;
import com.atSistemas.atWeek.model.entity.Client;
import com.atSistemas.atWeek.model.entity.Rate;
import com.atSistemas.atWeek.model.entity.Rental;
import com.atSistemas.atWeek.service.car.CarServiceImp;
import com.atSistemas.atWeek.service.client.ClientServiceImp;
import com.atSistemas.atWeek.service.rate.RateServiceImp;
import com.atSistemas.atWeek.service.rateCar.RateCarServiceImp;
import com.atSistemas.atWeek.service.rental.RentalServiceImp;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.Period;

@RunWith(MockitoJUnitRunner.class)
public class RentalService {

    @InjectMocks
    private RentalServiceImp service;

    @Mock
    private CarServiceImp carService;

    @Mock
    private RateServiceImp rateService;

    @Mock
    private ClientServiceImp clientService;

    @Mock
    private RateCarServiceImp rateCarService;

    @Test
    public void whenCreateRentShouldReturnRentWithCurrentRatePerNumberOfDays(){

        final Car carToRent = new Car();
        carToRent.setId(1);
        carToRent.setCarPlate("123ABC");
        carService.create(carToRent);

        final Rate currentRate = new Rate();
        final Double currentRatePrice = 21.50;
        final LocalDate currentRateStartDate = LocalDate.of(2019, 06, 01);
        final LocalDate currentRateEndDate = LocalDate.of(2019, 07, 01);
        currentRate.setId(1);
        currentRate.setPrice(currentRatePrice);
        currentRate.setStartDate(currentRateStartDate);
        currentRate.setEndDate(currentRateEndDate);
        rateService.create(currentRate);

        final Rate notCurrentRate = new Rate();
        final Double notCurrentRatePrice = 1.50;
        final LocalDate notCurrentRateStartDate = LocalDate.of(2019, 03, 01);
        final LocalDate notCurrentRateEndDate = LocalDate.of(2019, 04, 01);
        notCurrentRate.setId(2);
        notCurrentRate.setPrice(notCurrentRatePrice);
        notCurrentRate.setStartDate(notCurrentRateStartDate);
        notCurrentRate.setEndDate(notCurrentRateEndDate);
        rateService.create(currentRate);

        rateCarService.associateRateCar(1,1);
        rateCarService.associateRateCar(2,1);

        final Client clientRenting = new Client();
        clientRenting.setId(1);
        clientRenting.setDni("123456");
        clientService.create(clientRenting);

        final Rental newRental = new Rental();
        final LocalDate newRentalStartDate = LocalDate.of(2019, 06, 10);
        final LocalDate newRentalEndDate = LocalDate.of(2019, 06, 12);
        newRental.setClient(clientRenting);
        newRental.setCar(carToRent);
        newRental.setStartDate(newRentalStartDate);
        newRental.setEndDate(newRentalEndDate);

        // FIXME: I have no idea why client does not exist...
        // Client has been created with Mock service and associate to Rental on line #80
        Mockito.when(service.create(newRental)).thenReturn(newRental);

        Period newRentalPeriod = Period.between(newRentalStartDate, newRentalEndDate);
        Assert.assertEquals(java.util.Optional.ofNullable(newRental.getPrice()),
                    newRentalPeriod.getDays() * currentRatePrice);

    }
}
