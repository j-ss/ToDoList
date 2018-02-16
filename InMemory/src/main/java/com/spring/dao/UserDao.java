package com.spring.dao;

import com.spring.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private SessionFactory factory;

    public void save(User user)
    {
        Session session=factory.getCurrentSession();
        session.saveOrUpdate(user);
    }
}
