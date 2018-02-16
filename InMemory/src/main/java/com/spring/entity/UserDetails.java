package com.spring.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "userdetails")
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
//    @NotNull(message ="required")
//    @Size(min = 1,max = 10 ,message = "length b/w 1 to 10")
    @Column(name = "FirstName")
    private String firstName;

//    @NotNull(message ="required")
//    @Size(min = 1,max = 10 ,message = "length b/w 1 to 10")
    @Column(name = "LastName")
    private String lastName;

//    @NotNull(message ="required")
//    @Pattern(regexp = "\\w+@(gmail|yahoo|outlook).com")
    @Column(name = "UserName",unique = true)
    private String userName;

//    @NotNull(message ="required")
//    @Size(min = 6,message = "min length 6")
    @Column(name = "Password")
    private String password;

   // @NotNull(message ="required")
   // @Pattern(regexp = "^([0]|(\\+91))?[789]\\d{9}$")
    @Column(name = "Contact")
    private long contact;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "todo_id")
    private List<ToDo> todo;
    //no arg constructor

    public UserDetails() {
    }


    // getter and setter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public List<ToDo> getTodo() {
        return todo;
    }

    public void setTodo(List<ToDo> todo) {
        this.todo = todo;
    }

    public void addToDo(ToDo toDo)
    {
        if(todo==null)
            todo=new ArrayList<>();
        todo.add(toDo);
    }
}
