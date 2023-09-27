package com.example.ticket_api.services;

import com.example.ticket_api.entities.Basket;
import com.example.ticket_api.entities.Ticket;
import com.example.ticket_api.repositories.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BasketService {

    @Autowired
    private BasketRepository BasketRepo;

    public List<Basket> findAllBaskets() {
        return BasketRepo.findAll();
    }

    public Basket findOneBasket(String email) {
        return BasketRepo.findBasketByUserEmail(email);
    }

    public Basket findBasketByUser(User user) {
        String email = user.getUsername();
        return BasketRepo.findByUserEmail(email);
    }
//    public List<Ticket> findTicketsByBasket(Basket basket) {return BasketRepo.findByBasket(basket);}

    public void create(Basket Basket) {
        BasketRepo.save(Basket);
    }
    
//    public String deleteBasket(Optional<Basket> basket) {
//        return BasketRepo.delete(basket);
//    }
    
/*
    public void deleteAllBaskets() {
        BasketRepo.deleteAll();
    }
*/

}
