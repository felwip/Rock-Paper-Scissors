package com.rps.restservicecors.controller;

import com.rps.restservicecors.model.User;
import com.rps.restservicecors.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/user")
@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public int addUser(@RequestBody User user) {
        return this.userService.addUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }


    @GetMapping(path = "{id}")
    public User getUserById(@PathVariable("id") UUID id) {
        return this.userService.getUserById(id);
    }


    @DeleteMapping(path = "{id}")
    public int deleteUserById(@PathVariable("id") UUID id) {
        return this.userService.deleteUserById(id);
    }


    @PutMapping(path = "{id}")
    public int updateUserById(@PathVariable("id") UUID id, @RequestBody User user) {
        return this.userService.updateUserById(id, user);
    }
/*
    private final AtomicLong counter = new AtomicLong();
    @GetMapping("/user")
    public Void greeting(@RequestParam(required = false, defaultValue = "Anonymous") String name) {
        System.out.println("==== get greeting ====");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
*/
}