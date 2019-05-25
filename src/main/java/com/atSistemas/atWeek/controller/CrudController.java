package com.atSistemas.atWeek.controller;

import com.atSistemas.atWeek.model.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public abstract class CrudController<T, R> {

/*
    @Autowired
    private final R repo = this.repo;

    @GetMapping("/{id}")
    public T findOne(@PathVariable("id") Integer id){
        return repo.findById(id).orElse(new T());
    }

    @PostMapping
    public T create(@RequestBody T t){
        return repo.save(t);
    }

    @PutMapping Mapping("/{id}")
    public Client edit(@PathVariable("id") Integer id){
        //TODO: crear metodo update con 200 o 404 - ideal excepción
        return repo.findById(id).orElse(new Client());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        //TODO: crear metodo delete con 200 o 404 - ideal exceptión
    }

 */
}
