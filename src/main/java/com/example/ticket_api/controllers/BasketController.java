package com.example.ticket_api.controllers;

import com.example.ticket_api.entities.Basket;
import com.example.ticket_api.entities.User;
import com.example.ticket_api.entities.dto.UserDto;
import com.example.ticket_api.repositories.UserRepository;
import com.example.ticket_api.services.BasketService;
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

    @GetMapping({"", "/all"})
    public List<Basket> getAllBaskets(){

        List<Basket> basketlist = basketServ.findAllBaskets();
        return basketlist;
    }


    @GetMapping("/basket/{id}")
    public ResponseEntity<Basket> findOneBasket(@RequestBody Long id){
      Optional<Basket> basket = basketServ.findOneBasket(id);
        if (basket!= null) {
            return ResponseEntity.status(410).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping("/add/{email}")
    public ResponseEntity<Basket> createBasket(@PathVariable String email){
        Optional<User> u = userRepository.findUserByEmail(email);
        Basket basket = new Basket();
        basket.setUser(u.get());
        if (basket.getId() != null) {
            basketServ.create(basket);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(409).build();
        }

    }

    @PutMapping("/update")
    public ResponseEntity updateBasket(@RequestBody Basket Basket){

        if (Basket != null && basketServ.findOneBasket(Basket.getId()) == null) {
            basketServ.create(Basket);
            //TODO: vérifier que c'est la bonne méthode à utiliser
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(409).build();
        }

    }

//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity deleteBasket(@PathVariable Long id){
//        Optional<Basket> basket = basketServ.findOneBasket(id);
//        if (basket != null) {
//            basketServ.deleteBasket(basket);
//            return ResponseEntity.status(410).build();
//        } else {
//            return ResponseEntity.status(404).build();
//        }
//
//    }

}
