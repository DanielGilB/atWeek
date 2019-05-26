package com.atSistemas.atWeek.controller;


import com.atSistemas.atWeek.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


public class CrudController<T, ID> {

    @Autowired
    private CrudService<T, ID> service;

    /*public CrudController(CrudService<T, ID> service){
        this.service = service;
    }

     */

    @PostMapping
    public T create(@RequestBody T t){
        return service.create(t);
    }

}
