package io.khasang.freefly.dao.impl;

import io.khasang.freefly.dao.PersonDao;
import io.khasang.freefly.entity.Person;

public class PersonDaoImpl extends BasicDaoImpl<Person> implements PersonDao {
    public PersonDaoImpl(Class<Person> entityClass) {
        super(entityClass);
    }
}
