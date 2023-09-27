package com.example.ticket_api.controllers;

import com.example.ticket_api.entities.Basket;
import com.example.ticket_api.entities.User;
import com.example.ticket_api.entities.dto.UserDto;
import com.example.ticket_api.repositories.BasketRepository;
import com.example.ticket_api.repositories.UserRepository;
import com.example.ticket_api.services.BasketService;
import com.example.ticket_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/baskets")
public class BasketController {
    
    @Autowired
    BasketService basketServ;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BasketRepository basketRepository;
    @Autowired
    UserService userService;

    @GetMapping({"", "/all"})
    public List<Basket> getAllBaskets(){

        List<Basket> basketlist = basketServ.findAllBaskets();
        return basketlist;
    }


    @GetMapping("/basket/{email}")
    public ResponseEntity<Basket> findOneBasket(@PathVariable String email){
        Basket basket = basketServ.findOneBasket(email);
        System.out.println("basket  lié à cet email: " + basket);
        if (basket!= null) {
            return ResponseEntity.status(410).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping("/add/{email}")
    public ResponseEntity<Basket> createBasket(@PathVariable String email){
        User u = userRepository.findByEmail(email);
        System.out.println("user : " + u);
        Basket basket = new Basket();
        System.out.println("panier : " + basket.toString());
            basketServ.create(basket);
        System.out.println("panier : " + basket.getId() + basket + basket.toString());
//            basketServ.findOneBasket();
            u.setBasket(basket);
            userRepository.save(u);
        System.out.println("user après intégration du panier :" + u);
            return ResponseEntity.ok().build();
    }

//    @PutMapping("/update")
//    public ResponseEntity updateBasket(@RequestBody Basket Basket){
//
//        if (Basket != null && basketServ.findOneBasket(Basket.getId()) == null) {
//            basketServ.create(Basket);
//            //TODO: vérifier que c'est la bonne méthode à utiliser
//            return ResponseEntity.ok().build();
//        } else {
//            return ResponseEntity.status(409).build();
//        }
//
//    }

//    @DeleteMapping("/delete/{email}")
//    public ResponseEntity deleteBasket(@PathVariable String email){
//        User u = userService.findUserByEmail02(email);
//        Basket basket = basketServ.findBasketByUser(u);
//        if (basket != null) {
//            basketRepository.delete(basket);
//            return ResponseEntity.status(410).build();
//        } else {
//            return ResponseEntity.status(404).build();
//        }
//
//    }

}
