package io.khasang.freefly.service.impl;

import io.khasang.freefly.dao.PersonDao;
import io.khasang.freefly.entity.Person;
import io.khasang.freefly.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Override
    public Person getPersonById(long id) {
        return personDao.getById(id);
    }

    @Override
    public Person addPerson(Person person) {
        return personDao.create(person);
    }
}
