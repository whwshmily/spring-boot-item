package com.whw.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class TestDaoImpl<T> implements Testdao {
    @Autowired
    private SessionFactory factory;

    private Class clazz;

    public TestDaoImpl(){
       ParameterizedType pt = (ParameterizedType) getClass().getGenericSuperclass();
       if (pt!=null){
           clazz = (Class) pt.getActualTypeArguments()[0];
       }
    }


    public Session getSession(){
        return factory.getCurrentSession();
    }
    public int save(Object obj) {
        return (Integer) getSession().save(obj);
    }

    public Object get(int id) {
        return getSession().get(clazz,id);
    }

    public void update(Object obj) {
        getSession().update(obj);
    }

    public int count() {
        return 0;
    }

    public List<?> findAll() {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<?> query = builder.createQuery(clazz);
        Root<?> root = query.from(clazz);
        return session.createQuery(query).getResultList();
    }

    public void delete(Object obj) {

    }
}
