package com.spring.service;

import com.spring.dao.AuthorityDao;
import com.spring.dao.ToDoDao;
import com.spring.dao.UserDao;
import com.spring.dao.UserDetailsDao;
import com.spring.entity.Authority;
import com.spring.entity.ToDo;
import com.spring.entity.User;
import com.spring.entity.UserDetails;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
     private UserDetailsDao userDetailsDao;
     @Autowired
     private UserDao userDao;
     @Autowired
     private AuthorityDao authority;
     @Autowired
     private ToDoDao todo;

    @Transactional
    public void save(UserDetails object)
    {
        userDetailsDao.save(object);
    }

    @Transactional
    public void save(User object)
    {
        userDao.save(object);
    }

    @Transactional
    public void save(Authority object)
    {
        authority.save(object);
    }

    @Transactional
    public void save(ToDo toDo){todo.save(toDo);}

    @Transactional
    public void saveToDo(ToDo toDo,String user)
    {
        userDetailsDao.saveToDo(toDo,user);
    }
}
