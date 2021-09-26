package com.rehnemacollege.backend.controller;

import com.rehnemacollege.backend.model.User;
import com.rehnemacollege.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/get/{id}")
    public User get(@PathVariable("id") Integer id) {
        return userRepo.get(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody User user) {
        userRepo.addOrUpdate(user);
    }

    @GetMapping("/get")
    public Collection<User> all() {
        return userRepo.getAll();
    }
}
