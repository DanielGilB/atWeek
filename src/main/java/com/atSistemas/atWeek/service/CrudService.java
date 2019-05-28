package com.atSistemas.atWeek.service;


public interface CrudService<T, ID> {

    T create(T t);

    T findOne(ID id);
}
