package com.twekll.CRUD.controller;

import com.twekll.CRUD.Repo.UserRepo;
import com.twekll.CRUD.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
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
    @PostMapping("/save")
    public String saveUser(@RequestBody User user){
      userRepo.save(user);
      return "saved....";
    }
    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable long id,@RequestBody User user){
        User UpdateUser=userRepo.findById(id).get();
        UpdateUser.setFirstName(user.getFirstName());
        UpdateUser.setLastName(user.getLastName());
        UpdateUser.setAge(user.getAge());
        UpdateUser.setOccumation(user.getOccumation());
    userRepo.save(UpdateUser);
        return "updated....";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id){
        User DeleteUser=userRepo.findById(id).get();

        userRepo.delete(DeleteUser);
        return "Deleted user ...."+id;
    }

}
