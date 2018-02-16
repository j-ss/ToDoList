package com.spring.dao;

import com.spring.entity.Authority;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorityDao {

    @Autowired
    private SessionFactory factory;

    public void save(Authority user)
    {
        Session session=factory.getCurrentSession();
        session.saveOrUpdate(user);
    }
}
