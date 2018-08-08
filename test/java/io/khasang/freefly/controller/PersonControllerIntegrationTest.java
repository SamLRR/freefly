package io.khasang.freefly.controller;

import io.khasang.freefly.entity.Address;
import io.khasang.freefly.entity.Person;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertNotNull;


public class PersonControllerIntegrationTest {
    public static final String ROOT = "http://localhost:8080/person";
    public static final String ADD = "/add";
    public static final String GET_BY_ID = "/get";

    @Test
    public void addPerson() {
        Person person = createPerson();
        RestTemplate template = new RestTemplate();
        ResponseEntity<Person> entity = template.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Person.class,
                person.getId()
        );

//        assertEquals("OK", entity.getStatusCode().getReasonPhrase());
//        assertNotNull(entity.getBody());
    }

    private Person createPerson() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Person person = prefillPerson();

        HttpEntity<Person> entity = new HttpEntity<>(person, headers);
        RestTemplate template = new RestTemplate();
        Person createdPerson = template.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                entity,
                Person.class
        ).getBody();
        assertNotNull(createdPerson);
//        assertEquals("Barsik", createdPerson.getAddresses().get(0));

        return createdPerson;

    }

    private Person prefillPerson() {
        Person person = new Person();

        Address address1 = new Address();
        address1.setStreet("12th Avenue");
        address1.setNumber("12A");
        Address address2 = new Address();
        address2.setStreet("18th Avenue");
        address2.setNumber("18B");

        person.getAddresses().add(address1);
        person.getAddresses().add(address2);
        return person;
    }
}