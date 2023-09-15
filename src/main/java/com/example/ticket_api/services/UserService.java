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

    public ResponseEntity<String> deleteUser (User user) {
        if (user.getFirstName() != null && user.getLastName() != null && user.getEmail() != null && user.getPassword() != null) {
            User u = userRepo.findUserByEmailAndPassword(user.getEmail(), user.getPassword());
            userRepo.delete(u);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
        }
    }
    public ResponseEntity<String> deleteAllUsers () {
        userRepo.deleteAll();
        List<User> users = userRepo.findAll();
        if (users.isEmpty()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(null); // Retourne un code NO CONTENT si l'objet est vide.
        } else {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
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

    public ResponseEntity<User> updatePassword (UserDto userToUpdate) {
        User user = userRepo.findUserByEmailAndPassword(userToUpdate.getEmail(), userToUpdate.getPassword());
        if (user != null) {
            user.setPassword(userToUpdate.getPassword02());
            userRepo.save(user);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
        }
    }
        public ResponseEntity<User> updateUser (User userToUpdate) {
            User user = userRepo.findUserByEmailAndPassword(userToUpdate.getEmail(), userToUpdate.getPassword());
            if (user!=null) {
                user.setEmail(userToUpdate.getEmail());
                user.setPassword(userToUpdate.getPassword());
                user.setFirstName(userToUpdate.getFirstName());
                user.setLastName(userToUpdate.getLastName());
                if (userToUpdate.getSoldTicketsNumber()!=null) {
                    user.setSoldTicketsNumber(userToUpdate.getSoldTicketsNumber());
                }
                if (userToUpdate.getAdmin()!=null) {
                    user.setAdmin(userToUpdate.getAdmin());
                }
                userRepo.save(user);
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
            }
        }

//        public ResponseEntity<User> login (Model model, String emailUser, String passwordUser) {
//            User u = userRepo.findUserByEmailAndPassword(emailUser, passwordUser);
//            if (u==null) {
//                System.out.println("utilisateur non trouvé");
//                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null); // Retourne un code NO CONTENT si l'objet est vide.
//            } else {
//                System.out.println("utilisateur trouvé, connexion en cours");
//                HttpServletRequest request =null;
//                HttpSession httpSession = request.getSession();
//                httpSession.setAttribute("username", u.getFirstName());
//                return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
//            }
//        }
//
//        public String logoff (HttpSession httpSession, String username) {
//            System.out.println("Déconnexion en cours");
//            httpSession.invalidate();
//            return "Déconnexion réussie";
//        }
    }
