package com.atSistemas.atWeek.service.client;

import com.atSistemas.atWeek.model.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    /**
     * search a client by dni
     * @param dni
     * @return client with {dni}
     */
    Optional<Client> search(String dni);

    /**
     * find a client by id
     * @param id
     * @return client with {id} if exists
     */
    Optional<Client> findOne(Integer id);

    /**
     * return list with all client else empty list
     * @return list with all exsiting cars
     */
    List<Client> findAll();

    /**
     * create a new client
     * @param client
     * @return new client
     */
    Client create(Client client);

    /**
     * update existing client
     * @param client
     * @return client updated
     */
    Client update(Client client);

    /**
     * delete existing client
     * @param client
     */
    void delete(Client client);
}
