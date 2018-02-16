package com.spring.controller;

import com.spring.dao.ToDoDao;
import com.spring.entity.ToDo;
import com.spring.entity.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HomeController {

    @Autowired
    private ToDoDao toDo;

    @GetMapping("/")
    public String homePage()
    {

        return "home";
    }

    @GetMapping("/register")
    public String registerPage(Model model)
    {
        model.addAttribute("userdetail",new UserDetails());
        return "register";
    }
    @GetMapping("/create")
    public String create(Model model)
    {
        model.addAttribute("todo",new ToDo());
        return "todo";
    }
}
