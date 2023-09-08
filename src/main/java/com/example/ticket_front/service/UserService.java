package com.example.ticket_front.service;

import com.example.ticket_front.entity.User;
import com.example.ticket_front.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public ResponseEntity<User> createUser (User user) {
        if (user.getFirstNameUser() != null && user.getLastNameUser() != null && user.getEmailUser() != null && user.getPasswordUser() != null) {
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

    public ResponseEntity<User> login (Model model, String emailUser, String passwordUser) {
        User u = userRepo.findByEmailUserAndPasswordUser(emailUser, passwordUser);
        if (u==null) {
            System.out.println("utilisateur non trouvé");
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null); // Retourne un code NO CONTENT si l'objet est vide.
        } else {
            System.out.println("utilisateur trouvé, connexion en cours");
            HttpServletRequest request =null;
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("username", u.getFirstNameUser());
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
