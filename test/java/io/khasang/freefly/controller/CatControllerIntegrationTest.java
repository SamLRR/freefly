package io.khasang.freefly.controller;

import io.khasang.freefly.entity.Cat;
import io.khasang.freefly.entity.CatWoman;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class CatControllerIntegrationTest {
    public static final String ROOT = "http://localhost:8080/cat";
    public static final String ADD = "/add";
    public static final String GET_BY_ID = "/get";

    @Test
    public void addCat() {
        Cat cat = createCat();

        RestTemplate template = new RestTemplate();
        ResponseEntity<Cat> entity = template.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Cat.class,
                cat.getId()
        );

        assertEquals("OK", entity.getStatusCode().getReasonPhrase());
        assertNotNull(entity.getBody());
    }

    private Cat createCat() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Cat cat = prefillCat();

        HttpEntity<Cat> entity = new HttpEntity<>(cat, headers);
        RestTemplate template = new RestTemplate();
        Cat createdCat = template.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                entity,
                Cat.class
        ).getBody();
        assertNotNull(createdCat);
        assertEquals("Barsik", createdCat.getName());

        return createdCat;

    }

    private Cat prefillCat() {
        Cat cat = new Cat();
        cat.setName("Barsik");
        cat.setDescription("good");
        cat.setColorId(2);

        CatWoman catWoman1 = new CatWoman();
        catWoman1.setName("Riska");
        catWoman1.setDescription("pretty");

        CatWoman catWoman2 = new CatWoman();
        catWoman2.setName("Murka");
        catWoman2.setDescription("hungry");

        List<CatWoman> catWomanList = new ArrayList<>();
        catWomanList.add(catWoman1);
        catWomanList.add(catWoman2);

        cat.setCatWomanList(catWomanList);
        return cat;
    }
}