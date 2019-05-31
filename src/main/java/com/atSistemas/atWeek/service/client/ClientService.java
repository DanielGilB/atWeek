package com.atSistemas.atWeek.service.client;

import com.atSistemas.atWeek.model.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    /**
     * find a client by id
     * @param id
     * @return
     */
    Optional<Client> findOne(Integer id);

    /**
     * return list with all client else empty list
     * @return
     */
    List<Client> findAll();

    /**
     * create a new client
     * @param client
     * @return
     */
    Client create(Client client);

    /**
     * update existing client
     * @param client
     * @return
     */
    Client update(Client client);

    /**
     * delete existing client
     * @param client
     */
    void delete(Client client);
}
