package com.example.ticket_api.services;

import com.example.ticket_api.entities.CreditCard;
import com.example.ticket_api.repositories.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditCardService {

    @Autowired
    private CreditCardRepository CreditCardRepo;

    public List<CreditCard> findAllCreditCards() {
        return CreditCardRepo.findAll();
    }

    public Optional<CreditCard> findOneCreditCard(Long id) {
        return CreditCardRepo.findById(id);
    }

    public void create(CreditCard CreditCard) {
        CreditCardRepo.save(CreditCard);
    }
    
    public void deleteCreditCard(Long id) {
        CreditCardRepo.deleteById(id);
    }
    
/*
    public void deleteAllCreditCards() {
        CreditCardRepo.deleteAll();
    }
*/

}
