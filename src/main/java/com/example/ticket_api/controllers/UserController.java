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
@RequestMapping("/opi")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/allusers")
    public ResponseEntity<List<User>> searchAllUsers(Model model) {
        return userService.findAllUsers(model);
    }
    @GetMapping("/user/{email}")
    public ResponseEntity<User> searchUserByEmail(@PathVariable String email) {
        return userService.findUserByEmail(email);
    }

    @GetMapping("/otheruser/{firstName}")
    public ResponseEntity<List<User>> searchByFirstName(@PathVariable String firstName) {
        return userService.findUsersByName(firstName);
    }

    @PostMapping("/createusers")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/updateusers")
    public ResponseEntity<User> updateUser(@RequestBody User user) {return userService.updateUser(user);}

    @PostMapping("/updatepassword/{email}/{password}")
    public ResponseEntity<User> updatePassword(@PathVariable String email, @PathVariable String password) {return userService.updatePassword(email, password);}

    @PostMapping("/deleteuser")
    public ResponseEntity<String> deleteUser(@RequestBody String email) {return userService.deleteUser(email);}

    @PostMapping("/deleteallusers")
    public ResponseEntity<String> deleteAllUsers() {return userService.deleteAllUsers();}
}
