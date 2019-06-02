package com.atSistemas.atWeek.controller.api;

import com.atSistemas.atWeek.exception.NotFoundException;
import com.atSistemas.atWeek.mapper.rate.RateMapper;
import com.atSistemas.atWeek.model.dto.RateDTO;
import com.atSistemas.atWeek.service.rate.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rate")
public class RateController {

    @Autowired
    private RateService service;

    @Autowired
    private RateMapper mapper;

    @GetMapping("/{id}")
    public RateDTO findOne(@PathVariable("id") Integer id){
        return Optional.ofNullable(id)
                .flatMap(service::findOne)
                .map(mapper::map)
                .orElseThrow(() -> new NotFoundException("This rate does not exist"));
    }

    @GetMapping
    public List<RateDTO> findAll(){
        //TODO: paginar
        return mapper.map(service.findAll());
    }


    @PostMapping
    public RateDTO create(@RequestBody RateDTO dto){
        return Optional.ofNullable(dto)
                .map(mapper::map)
                .map(service::create)
                .map(mapper::map)
                .orElseThrow(() -> new NotFoundException("This rate does not exist"));
    }

    @PutMapping
    public RateDTO update(@RequestBody RateDTO dto){
        return Optional.ofNullable(dto)
                .map(mapper::map)
                .map(service::update)
                .map(mapper::map)
                .orElseThrow(() -> new NotFoundException("This rate does not exist"));
    }

    @DeleteMapping
    public void delete(@RequestBody RateDTO dto){
        Optional.ofNullable(dto)
                .map(mapper::map)
                .ifPresent(service::delete);
    }
}
