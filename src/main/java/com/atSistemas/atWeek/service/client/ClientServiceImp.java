package com.atSistemas.atWeek.service.client;

import com.atSistemas.atWeek.dao.ClientRepository;
import com.atSistemas.atWeek.model.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImp implements ClientService{

    @Autowired
    private ClientRepository repository;

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
        return repository.save(client);
    }

    @Override
    public Client update(Client client) {
        return repository.save(client);
    }

    @Override
    public void delete(Client client) {
        repository.delete(client);
    }
}
