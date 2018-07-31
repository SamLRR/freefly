package io.khasang.freefly.dao.impl;

import io.khasang.freefly.dao.BasicDao;
import io.khasang.freefly.entity.Cat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

@Transactional
public class BasicDaoImpl<T>  implements BasicDao<T> {
    private final Class<T> entityClass;
    
    @Autowired
    protected SessionFactory sessionFactory;

    public BasicDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public T getById(long id) {
        return getSessionFactory().get(entityClass,id);
    }

    @Override
    public T create(T entity) {
        getSessionFactory().save(entity);
        return entity;
    }

    private Session getSessionFactory() {
        return sessionFactory.getCurrentSession();
    }
}
