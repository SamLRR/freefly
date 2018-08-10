package io.khasang.freefly.service.impl;

import io.khasang.freefly.dao.PersonDao;
import io.khasang.freefly.dto.PersonDTO;
import io.khasang.freefly.entity.Person;
import io.khasang.freefly.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;
    @Autowired
    private PersonDTO personDTO;

    @Override
    public PersonDTO getPersonDTOById(long id) {
        return personDTO.getPersonDTO(personDao.getById(id));
    }

    @Override
    public Person addPerson(Person person) {
        return personDao.create(person);
    }

    @Override
    public List<PersonDTO> getAllPersonsDTO() {
        return personDTO.getPersonDTOList(personDao.getList());
    }
}
