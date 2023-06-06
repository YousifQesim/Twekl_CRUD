package com.twekll.CRUD.controller;

import com.twekll.CRUD.Repo.UserRepo;
import com.twekll.CRUD.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController
{
    @Autowired
    private UserRepo userRepo;
    @GetMapping("/")
    public String home(){
        return "welcome";
    }

    @GetMapping("/users")
    public List<User> Getusers(){
        return userRepo.findAll();
    }



}
