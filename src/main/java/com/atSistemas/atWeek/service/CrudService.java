package com.atSistemas.atWeek.service;

public interface CrudService<T, ID> {

    public T create(T t);

    public T findOne(ID id);
}
