package io.khasang.freefly.service;

import io.khasang.freefly.dto.PersonDTO;
import io.khasang.freefly.entity.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService {

    /**
     * method for getting person by id
     * @param id  - person's id
     * @return person by id
     */
    PersonDTO getPersonDTOById(long id);

    /**
     * method for add person
     * @param person - new person for creation
     * @return created person
     */
    Person addPerson(Person person);

    /**
     * method for getting all persons
     * @return list persons
     */
    List<PersonDTO> getAllPersonsDTO();
}
