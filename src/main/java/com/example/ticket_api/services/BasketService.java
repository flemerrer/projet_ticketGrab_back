package com.example.ticket_api.services;

import com.example.ticket_api.entities.Basket;
import com.example.ticket_api.repositories.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Optional<Basket> findBasketById(Long id) { 
        return BasketRepo.findById(id);
    }

    public void create(Basket Basket) {
        BasketRepo.save(Basket);
    }
    
    public void deleteturorialById(Long id) {
        BasketRepo.deleteById(id);
    }
    
/*
    public void deleteAllBaskets() {
        BasketRepo.deleteAll();
    }
*/

}
