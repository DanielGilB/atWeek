package com.atSistemas.atWeek.service.client;

import com.atSistemas.atWeek.dao.ClientRepository;
import com.atSistemas.atWeek.exception.ConflictException;
import com.atSistemas.atWeek.exception.NotFoundException;
import com.atSistemas.atWeek.exception.UnprocessableException;
import com.atSistemas.atWeek.model.entity.Client;
import com.atSistemas.atWeek.model.entity.Rental;
import com.atSistemas.atWeek.service.rental.RentalServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImp implements ClientService{

    @Autowired
    private ClientRepository repository;

    @Autowired
    private RentalServiceImp service;

    @Override
    public List<Rental> findRentals(Integer id) throws NotFoundException{

        return Optional.ofNullable(id)
                .flatMap(this::findOne)
                .map(service::findRentalsClient)
                .orElseThrow(() -> new NotFoundException("There is not client with this id"));
    }

    @Override
    public void validate(Client client) throws ConflictException, UnprocessableException {

        Optional.ofNullable(client)
                .map(Client::getDni)
                .orElseThrow(() -> new UnprocessableException("Dni is field required"));

        Optional.ofNullable(client)
                .map(Client::getDni)
                .flatMap(this::search)
                .ifPresent(c -> {
                    if(!c.getId().equals(client.getId())) // checks if is the same client
                        throw new ConflictException("There is already a client with that dni");
                });
    }

    @Override
    public Optional<Client> search(String dni) {
        return repository.findByDni(dni);
    }

    @Override
    public Optional<Client> findOne(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Client> findAll() {
        return repository.findAll();
    }

    @Override
    public Client create(Client client) {
        this.validate(client);
        return repository.save(client);
    }

    @Override
    public Client update(Client client) {
        this.validate(client);
        return repository.save(client);
    }

    @Override
    public void delete(Client client) {
        repository.delete(client);
    }
}
