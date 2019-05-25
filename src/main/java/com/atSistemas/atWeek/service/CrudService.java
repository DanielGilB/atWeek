package com.atSistemas.atWeek.service;

import org.springframework.stereotype.Service;

@Service
public interface CrudService<T, ID> {

    public T create(T t);

    public T findOne(ID id);
}
