package com.atSistemas.atWeek.mapper.client;

import com.atSistemas.atWeek.model.dto.ClientDTO;
import com.atSistemas.atWeek.model.entity.Client;

import java.util.List;

public interface ClientMapper {

    /**
     * map ClientDTO to client entity
     * @param dto
     * @return
     */
    Client map(ClientDTO dto);

    /**
     * map client entity to ClientDTO
     * @param client
     * @return
     */
    ClientDTO map(Client client);

    /**
     * map a list of Clients to list of ClientDTOs
     * @param clients
     * @return
     */
    List<ClientDTO> map(List<Client> clients);
}
