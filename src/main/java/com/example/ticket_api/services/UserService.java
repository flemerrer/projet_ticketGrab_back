package com.example.ticket_api.services;

import com.example.ticket_api.entities.User;
import com.example.ticket_api.repositories.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public ResponseEntity<User> createUser (User user) {
        if (user.getFirstName() != null && user.getLastName() != null && user.getEmail() != null && user.getPassword() != null) {
            user.setAdmin(false);
            user.setSoldTicketsNumber(0);
            userRepo.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
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

    public ResponseEntity<User> updateUser (User userToUpdate) {
        User user = userRepo.findUserByEmailAndPassword(userToUpdate.getEmail(), userToUpdate.getLastName());
        if (user!=null) {
            user.setEmail(user.getEmail());
            user.setPassword(user.getPassword());
            user.setFirstName(user.getFirstName());
            user.setLastName(user.getLastName());
            user.setSoldTicketsNumber(user.getSoldTicketsNumber());
            user.setAdmin(user.getAdmin());
            userRepo.save(user);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
        }
    }

    public ResponseEntity<User> login (Model model, String emailUser, String passwordUser) {
        User u = userRepo.findUserByEmailAndPassword(emailUser, passwordUser);
        if (u==null) {
            System.out.println("utilisateur non trouvé");
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null); // Retourne un code NO CONTENT si l'objet est vide.
        } else {
            System.out.println("utilisateur trouvé, connexion en cours");
            HttpServletRequest request =null;
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("username", u.getFirstName());
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
        }
    }

    public String logoff (HttpSession httpSession, String username) {
        System.out.println("Déconnexion en cours");
        httpSession.invalidate();
        return "Déconnexion réussie";
    }


//Méthodes de controller, pas de rest controller

//    public String showForm(Model model) {
//        model.addAttribute("user", new User());
//        return "create-user"; // Le nom de la vue du formulaire de création
//    }
//    public String submitForm(@ModelAttribute User user, Model model) {
//        model.addAttribute("user",  user);
//        userRepo.save(user);
//        return this.findAllUsers(model); // Le nom de la vue du formulaire de création
//    }
//
//    public String findAllUsers(Model model) {
//        List<User> users = userRepo.findAll();
//        model.addAttribute("users", users);
//        return "users";
//    }
}
