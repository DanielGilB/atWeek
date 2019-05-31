package com.atSistemas.atWeek.mapper.client;

import com.atSistemas.atWeek.model.dto.ClientDTO;
import com.atSistemas.atWeek.model.entity.Client;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ClientMapperImp implements ClientMapper {
    @Override
    public Client map(ClientDTO dto) {

        Client client = new Client();
        Optional<ClientDTO> clientDTO = Optional.ofNullable(dto);

        clientDTO.map(ClientDTO::getId).ifPresent(client::setId);
        clientDTO.map(ClientDTO::getDni).ifPresent(client::setDni);
        clientDTO.map(ClientDTO::getName).ifPresent(client::setName);

        return client;
    }

    @Override
    public ClientDTO map(Client client) {

        ClientDTO dto = new ClientDTO();
        Optional<Client> clientEntity = Optional.ofNullable(client);

        clientEntity.map(Client::getId).ifPresent(dto::setId);
        clientEntity.map(Client::getDni).ifPresent(dto::setDni);
        clientEntity.map(Client::getName).ifPresent(dto::setName);

        return dto;
    }

    @Override
    public List<ClientDTO> map(List<Client> clients) {

        return clients.stream()
                        .map(this::map)
                        .collect(Collectors.toList());
    }
}
