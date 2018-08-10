package io.khasang.freefly.controller;

import io.khasang.freefly.dto.PersonDTO;
import io.khasang.freefly.entity.Person;
import io.khasang.freefly.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    public PersonService personService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Person addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public PersonDTO getPersonById(@PathVariable(value = "id") String id) {
        return personService.getPersonDTOById(Long.parseLong(id));
    }

    @RequestMapping(value = "/get/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<PersonDTO> getAllPersons() {
        return personService.getAllPersonsDTO();
    }
}