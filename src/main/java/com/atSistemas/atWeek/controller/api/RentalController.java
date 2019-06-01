package com.atSistemas.atWeek.controller.api;

import com.atSistemas.atWeek.exception.ConflictException;
import com.atSistemas.atWeek.exception.NotFoundException;
import com.atSistemas.atWeek.mapper.rental.RentalMapper;
import com.atSistemas.atWeek.model.dto.RentalDTO;
import com.atSistemas.atWeek.service.rental.RentalServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rental")
public class RentalController {

    @Autowired
    private RentalServiceImp service;

    @Autowired
    private RentalMapper mapper;

    @GetMapping("/{id}")
    public RentalDTO findOne(@PathVariable("id") Integer id){
        return Optional.ofNullable(id)
                .flatMap(service::findOne)
                .map(mapper::map)
                .orElseThrow(() -> new NotFoundException("This rental does not exist"));
    }

    @GetMapping
    public List<RentalDTO> findAll(){
        //TODO: paginar
        return mapper.map(service.findAll());
    }


    @PostMapping
    public RentalDTO create(@RequestBody RentalDTO dto) throws NotFoundException, ConflictException {
        return Optional.ofNullable(dto)
                .map(mapper::map)
                .map(service::create)
                .map(mapper::map)
                .orElseThrow(() -> new NotFoundException("This rental does not exist"));
    }

    @PutMapping
    public RentalDTO update(@RequestBody RentalDTO dto){
        return Optional.ofNullable(dto)
                .map(mapper::map)
                .map(service::update)
                .map(mapper::map)
                .orElseThrow(() -> new NotFoundException("This rental does not exist"));
    }

    @DeleteMapping
    public void delete(@RequestBody RentalDTO dto){
        Optional.ofNullable(dto)
                .map(mapper::map)
                .ifPresent(service::delete);
    }
}
