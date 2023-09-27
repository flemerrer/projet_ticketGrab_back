package com.example.ticket_api.services;

import com.example.ticket_api.entities.User;
import com.example.ticket_api.entities.dto.UserDto;
import com.example.ticket_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<User> createUser (User user) {
        if (user.getFirstName() != null && user.getLastName() != null && user.getEmail() != null && user.getPassword() != null) {
            user.setAdmin(false);
            user.setSoldTicketsNumber(0);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepo.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
        }
    }

    public ResponseEntity<String> deleteUser (String email) {
        Optional<User> user = userRepo.findUserByEmail(email);
        if (user.get().getFirstName() != null && user.get().getLastName() != null && user.get().getEmail()!=null) {
            userRepo.delete(user.get());
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
        }
    }
    public ResponseEntity<String> deleteAllUsers () {
        List<User> users = userRepo.findAll();
        if (users.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } else {
            userRepo.deleteAll();
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(null); // Retourne un code NO CONTENT si l'objet est vide.
        }
    }
    public ResponseEntity<List<User>> findAllUsers (Model model) {
        List<User> users = userRepo.findAll();
        if (users.isEmpty()) {
            return ResponseEntity.notFound().build(); // Retourne un code NO CONTENT si l'objet est vide.
        } else {
            return ResponseEntity.ok(users);
        }
    }
    public ResponseEntity<User> findUserById (Long id) {
        User u=userRepo.findUserById(id);
        if (u!=null){
            return ResponseEntity.ok(u);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    public ResponseEntity<User> findUserByEmail(String email) {
       User u=userRepo.findByEmail(email);
        if (u != null){
            return ResponseEntity.ok(u);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    public User findUserByEmail02(String email) {
        User u=userRepo.findByEmail(email);
        if (u != null){
            return u;
        } else {
            return null;
        }
    }
    public ResponseEntity<List<User>> findUsersByName(String firstName) {
        List<User> users = userRepo.findUsersByFirstName(firstName);
        if (users.isEmpty()) {
            return ResponseEntity.notFound().build(); // Retourne un code NO CONTENT si l'objet est vide.
        } else {
            return ResponseEntity.ok(users);
        }
    }

    public ResponseEntity<User> updatePassword (String email, String password) {
        Optional<User> user = userRepo.findUserByEmail(email);
        if (user.isPresent()) {
            user.get().setPassword(passwordEncoder.encode(password));
            userRepo.save(user.get());
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }
        public ResponseEntity<User> updateUser (User userToUpdate) {
            Optional<User> user = userRepo.findUserByEmail(userToUpdate.getEmail());
            if (user.isPresent()) {
                user.get().setEmail(userToUpdate.getEmail());
                user.get().setPassword(userToUpdate.getPassword());
                user.get().setFirstName(userToUpdate.getFirstName());
                user.get().setLastName(userToUpdate.getLastName());
                if (userToUpdate.getSoldTicketsNumber()!=null) {
                    user.get().setSoldTicketsNumber(userToUpdate.getSoldTicketsNumber());
                }
                if (userToUpdate.getAdmin()!=null) {
                    user.get().setAdmin(userToUpdate.getAdmin());
                }
                userRepo.save(user.get());
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
            }
        }
    }
