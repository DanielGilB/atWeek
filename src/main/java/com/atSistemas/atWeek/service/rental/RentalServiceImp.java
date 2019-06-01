package com.atSistemas.atWeek.service.rental;

import com.atSistemas.atWeek.dao.RentalRepository;
import com.atSistemas.atWeek.exception.ConflictException;
import com.atSistemas.atWeek.exception.NotFoundException;
import com.atSistemas.atWeek.model.entity.Car;
import com.atSistemas.atWeek.model.entity.Client;
import com.atSistemas.atWeek.model.entity.Rental;
import com.atSistemas.atWeek.service.car.CarServiceImp;
import com.atSistemas.atWeek.service.client.ClientServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RentalServiceImp implements RentalService {

    @Autowired
    private RentalRepository repository;

    @Autowired
    private ClientServiceImp clientService;

    @Autowired
    private CarServiceImp carService;

    @Override
    public void validate(Rental rental) throws NotFoundException, ConflictException {

        Optional.ofNullable(rental.getClient())
                .map(Client::getId)
                .flatMap(clientService::findOne)
                .orElseThrow(() -> new NotFoundException("This client does not exist"));

        Optional.ofNullable(rental.getCar())
                .map(Car::getId)
                .flatMap(carService::findOne)
                .orElseThrow(() -> new NotFoundException("This car does not exist"));

        if(isCarOrderedBetweenDates(rental.getCar(), rental.getStartDate(), rental.getEndDate()))
            throw new ConflictException("This car is not available in this date");
    }

    @Override
    public boolean isCarOrderedBetweenDates(Car car, LocalDate startDate, LocalDate endDate){
        return repository.findFirstByStartDateBetweenAndCar(startDate, endDate, car).isPresent()
                || repository.findFirstByEndDateBetweenAndCar(startDate, endDate, car).isPresent();
    }

    @Override
    public Optional<Rental> findOne(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Rental> findAll() {
        return repository.findAll();
    }

    @Override
    public Rental create(Rental rental) {
        return repository.save(rental);
    }

    @Override
    public Rental update(Rental rental) {
        return repository.save(rental);
    }

    @Override
    public void delete(Rental rental) {
        repository.delete(rental);
    }
}
