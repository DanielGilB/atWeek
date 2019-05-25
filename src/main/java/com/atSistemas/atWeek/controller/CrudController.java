package com.atSistemas.atWeek.controller;


import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.*;


public class CrudController<T, ID> {

    private CrudRepository<T, ID> repository;

    public CrudController(CrudRepository<T, ID> repository){
        this.repository = repository;
    }

    @PostMapping
    public T create(@RequestBody T t){
        return repository.save(t);
    }

}
