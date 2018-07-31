package io.khasang.freefly.service.impl;

import io.khasang.freefly.dao.CatDao;
import io.khasang.freefly.entity.Cat;
import io.khasang.freefly.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatServiceImpl implements CatService {

    @Autowired
    private CatDao catDao;

    @Override
    public Cat addCat(Cat cat) {
        return catDao.create(cat);
    }
}
