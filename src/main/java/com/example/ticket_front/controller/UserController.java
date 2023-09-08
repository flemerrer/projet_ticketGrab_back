package com.example.ticket_front.controller;

import com.example.ticket_front.entity.User;
import com.example.ticket_front.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/allusers")
    public ResponseEntity<List<User>> searchAllTutorials(Model model) {
        return userService.findAllUsers(model);
    }

    @PostMapping("/createusers")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}
