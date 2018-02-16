package com.spring.controller;

import com.spring.entity.Authority;
import com.spring.entity.User;
import com.spring.entity.UserDetails;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/loginPage")
    public String showLoginPage()
    {
        return "login";
    }

    @RequestMapping(value ="/registerUser" ,method = RequestMethod.POST)
    public String register(@ModelAttribute("userdetail") UserDetails user)
    {
        String password=user.getPassword();
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        password=encoder.encode(password);
        user.setPassword(password);

        User user1=new User();
            user1.setUsername(user.getUserName());
            user1.setPassword(password);

        Authority authority=new Authority();
        authority.setUsername(user.getUserName());
        authority.setRole("ROLE_USER");
        userService.save(user);
        userService.save(user1);
        userService.save(authority);

        return "home";
    }
}
