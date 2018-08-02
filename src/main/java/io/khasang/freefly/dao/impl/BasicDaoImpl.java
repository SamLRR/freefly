package io.khasang.freefly.dao.impl;

import io.khasang.freefly.dao.BasicDao;
import io.khasang.freefly.entity.Cat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class BasicDaoImpl<T> implements BasicDao<T> {
    private final Class<T> entityClass;

    @Autowired
    protected SessionFactory sessionFactory;

    public BasicDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public T getById(long id) {
        return getSessionFactory().get(entityClass, id);
    }

    @Override
    public List<T> getList() {
        CriteriaBuilder criteriaBuilder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);
        Root<T> root = criteriaQuery.from(entityClass);

        criteriaQuery.select(root);

        return getSessionFactory().createQuery(criteriaQuery).list();
//        return (List<T>) getSessionFactory().createQuery("").list();
    }

    @Override
    public T create(T entity) {
        getSessionFactory().save(entity);
        return entity;
    }

    @Override
    public T update(T entity) {
        getSessionFactory().update(entity);
        return entity;
    }

    @Override
    public void remove(Cat cat) {
        getSessionFactory().delete(cat);
    }

    private Session getSessionFactory() {
        return sessionFactory.getCurrentSession();
    }
}
