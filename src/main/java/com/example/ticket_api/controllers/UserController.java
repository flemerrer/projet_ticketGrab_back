package com.example.ticket_api.controllers;

import com.example.ticket_api.entities.User;
import com.example.ticket_api.entities.dto.UserDto;
import com.example.ticket_api.services.UserService;
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
    @GetMapping("/allusers/{id}")
    public ResponseEntity<User> searchAllTutorials(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @PostMapping("/createusers")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/updateusers")
    public ResponseEntity<User> updateUser(@RequestBody User user) {return userService.updateUser(user);}

    @PostMapping("/updatepassword")
    public ResponseEntity<User> updatePassword(@RequestBody UserDto user) {return userService.updatePassword(user);}

    @DeleteMapping("/deleteuser")
    public ResponseEntity<String> deleteUser(@RequestBody User user) {return userService.deleteUser(user);}

    @PostMapping("/deleteallusers")
    public ResponseEntity<String> deleteAllUsers() {return userService.deleteAllUsers();}
}
