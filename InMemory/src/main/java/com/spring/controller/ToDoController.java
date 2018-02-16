package com.spring.controller;

import com.spring.entity.ToDo;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Controller
public class ToDoController {

    @Autowired
    private UserService userService;
    @RequestMapping(value = "/todo",method = RequestMethod.POST)
    //@ResponseBody
    public String addToDo(HttpServletRequest request,@ModelAttribute("todo")ToDo todo)  {
       String encrypt=request.getParameter("encryption");


       if(encrypt !=null)
       {    String key="jogisinghhello";
           //perform encryption
           byte[] key1;
           try{
           MessageDigest digest=MessageDigest.getInstance("SHA-256");
           digest.update(key.getBytes());
           key1=digest.digest();
           SecretKeySpec secKey=new SecretKeySpec(key1,"AES");

           //encrypt

           Cipher cipher=Cipher.getInstance("AES/ECB/PKCS5Padding");
           cipher.init(Cipher.ENCRYPT_MODE,secKey);
           String text= Base64.getEncoder().encodeToString(cipher.doFinal(todo.getText().getBytes()));
           todo.setText(text);
           }
           catch (Exception e)
           {
                e.printStackTrace();
           }
       }
       String user= SecurityContextHolder.getContext().getAuthentication().getName();
       userService.saveToDo(todo,user);
       userService.save(todo);

      return "home";
    }
}
