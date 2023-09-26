package com.example.ticket_api.controllers;

import com.example.ticket_api.entities.Basket;
import com.example.ticket_api.entities.User;
import com.example.ticket_api.services.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/baskets")
public class BasketController {
    
    @Autowired
    BasketService basketServ;

    @GetMapping({"", "/all"})
    public List<Basket> getAllBaskets(){

        List<Basket> basketlist = basketServ.findAllBaskets();
        return basketlist;
    }


    @GetMapping("/basket")
    public ResponseEntity<Basket> getOneBasket(@RequestBody Basket basket){
        User user = basket.getUser();
        if (user!= null) {
            basketServ.findBasketByUser(user);
            return ResponseEntity.status(410).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity createBasket(@RequestBody Basket Basket){

        if (Basket != null && basketServ.findOneBasket(Basket.getId()) == null) {
            basketServ.create(Basket);
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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBasket(@PathVariable Long id){

        if (basketServ.findOneBasket(id) != null) {
            basketServ.deleteBasket(id);
            return ResponseEntity.status(410).build();
        } else {
            return ResponseEntity.status(404).build();
        }

    }

}
