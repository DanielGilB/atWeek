package com.atSistemas.atWeek.service;

import com.atSistemas.atWeek.dao.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CrudServiceImp<T, ID> implements CrudService<T, ID> {

    @Autowired
    private CrudRepository<T, ID> repository;

    @Override
    public T create(T t) {
        return repository.save(t);
    }

    @Override
    public T findOne(ID id){
        return findOne(id);
    }
}