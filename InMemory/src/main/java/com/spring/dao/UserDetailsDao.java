package com.spring.dao;

import com.spring.entity.ToDo;
import com.spring.entity.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.management.Query;

@Repository
public class UserDetailsDao {

    @Autowired
    private SessionFactory factory;

    public void save(UserDetails user)
    {
        Session session=factory.getCurrentSession();
        session.saveOrUpdate(user);
    }

    public void saveToDo(ToDo toDo,String user)
    {
        Session session=factory.getCurrentSession();
        UserDetails object=(UserDetails)session.createQuery("from UserDetails where UserName=:"+user).getSingleResult();
        object.addToDo(toDo);
    }
}
