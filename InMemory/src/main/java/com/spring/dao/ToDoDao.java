package com.spring.dao;

import com.spring.entity.ToDo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ToDoDao {
    @Autowired
    private SessionFactory sessionFactory;
    public void save(ToDo toDo)
    {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(toDo);
    }

    public List<ToDo> getList(int start ,int offset)
    {
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("");
        query.setFirstResult(start);
        query.setMaxResults(offset);
        List<ToDo> result=query.getResultList();
        return result;

    }
}
