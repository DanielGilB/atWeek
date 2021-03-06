package com.atSistemas.atWeek.controller.api;

import com.atSistemas.atWeek.exception.ConflictException;
import com.atSistemas.atWeek.exception.NotFoundException;
import com.atSistemas.atWeek.exception.UnprocessableException;
import com.atSistemas.atWeek.mapper.client.ClientMapper;
import com.atSistemas.atWeek.mapper.rental.RentalMapper;
import com.atSistemas.atWeek.model.dto.ClientDTO;
import com.atSistemas.atWeek.model.dto.RentalDTO;
import com.atSistemas.atWeek.model.entity.Client;
import com.atSistemas.atWeek.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService service;

    @Autowired
    private ClientMapper mapper;

    @Autowired
    private RentalMapper rentalMapper;

    @GetMapping("dni/{dni}")
    public ClientDTO search(@PathVariable("dni") String dni){
        return Optional.ofNullable(dni)
                .flatMap(service::search)
                .map(mapper::map)
                .orElseThrow(() -> new NotFoundException("There is no client with this dni"));
    }

    @GetMapping("/{id}")
    public ClientDTO findOne(@PathVariable("id") Integer id){
        return Optional.ofNullable(id)
                .flatMap(service::findOne)
                .map(mapper::map)
                .orElseThrow(() -> new NotFoundException("This client does not exist"));
    }

    @GetMapping("/{id}/rental")
    public List<RentalDTO> findRentals(@PathVariable("id") Integer id){
        return rentalMapper.map(service.findRentals(id));
    }

    @GetMapping
    public List<ClientDTO> findAll(){
        //TODO: paginar
        return mapper.map(service.findAll());
    }

    @PostMapping
    public ClientDTO create(@RequestBody ClientDTO dto) throws ConflictException, UnprocessableException {
        return Optional.ofNullable(dto)
                .map(mapper::map)
                .map(service::create)
                .map(mapper::map)
                .orElseThrow(() -> new NotFoundException("This client does not exist"));
    }

    @PutMapping
    public ClientDTO update(@RequestBody ClientDTO dto) throws ConflictException, UnprocessableException{
        return Optional.ofNullable(dto)
                .map(mapper::map)
                .map(service::update)
                .map(mapper::map)
                .orElseThrow(() -> new NotFoundException("This client does not exist"));
    }

    @DeleteMapping
    public void delete(@RequestBody ClientDTO dto){
        Optional<Client> existsClient = service.findOne(dto.getId());
        if(!existsClient.isPresent()) throw new NotFoundException("This client does not exist");
        else service.delete(mapper.map(dto));
    }

}
