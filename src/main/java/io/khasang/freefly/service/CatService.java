package io.khasang.freefly.service;

import io.khasang.freefly.entity.Cat;

public interface CatService {
    /**
     * method for add cat
     *
     * @param cat - new cat for creation
     * @return created cat
     */
    Cat addCat(Cat cat);
}
