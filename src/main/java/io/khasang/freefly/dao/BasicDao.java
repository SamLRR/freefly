package io.khasang.freefly.dao;

import io.khasang.freefly.entity.Cat;

public interface BasicDao <T>{

    /**
     * method for add entity
     *
     * @param entity - new entity for creation
     * @return created entity
     */
    T create(T entity);
}
