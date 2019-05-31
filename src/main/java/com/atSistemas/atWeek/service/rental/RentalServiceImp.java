package com.atSistemas.atWeek.service.rental;

import com.atSistemas.atWeek.dao.RentalRepository;
import com.atSistemas.atWeek.model.entity.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentalServiceImp implements RentalService {

    @Autowired
    private RentalRepository repository;

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
