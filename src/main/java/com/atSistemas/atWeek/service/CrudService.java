package com.atSistemas.atWeek.service;

import org.springframework.stereotype.Service;

@Service
public interface CrudService<T, ID> {

    T create(T t);

    T findOne(ID id);
}
