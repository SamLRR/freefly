package io.khasang.freefly.dao;

import io.khasang.freefly.entity.Cat;

import java.util.List;

public interface BasicDao <T>{

    /**
     * method for add entity
     *
     * @param entity - new entity for creation
     * @return created entity
     */
    T create(T entity);

    T getById(long id);

    List<T> getList();
}
