package io.khasang.freefly.controller;

import io.khasang.freefly.entity.Cat;
import io.khasang.freefly.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cat")
public class CatController {

    @Autowired
    public CatService catService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Cat addCat(@RequestBody Cat cat) {
        return catService.addCat(cat);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Cat getCatById(@PathVariable(value = "id") String id) {
        return catService.getCatById(Long.parseLong(id));
    }

    @RequestMapping(value = "/get/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Cat> getAllCats() {
        return catService.getAllCats();
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Cat updateCat(@RequestBody Cat cat) {
        return catService.updateCat(cat);
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity removeCat(@PathVariable(value = "id") String id) {
        Cat catById = getCatById(id);
        if (catById== null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        catService.removeCatById(catById);
        return new ResponseEntity(HttpStatus.OK);
    }
}