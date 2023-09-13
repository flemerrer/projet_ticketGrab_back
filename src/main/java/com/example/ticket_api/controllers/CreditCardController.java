package com.example.ticket_api.controllers;

import com.example.ticket_api.entities.CreditCard;
import com.example.ticket_api.services.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CreditCardController {
    
    @Autowired
    CreditCardService creditCardServ;

    @GetMapping({"", "/all"})
    public List<CreditCard> getAllCreditCards(){

        List<CreditCard> creditCardlist = creditCardServ.findAllCreditCards();
        return creditCardlist;
    }

    @GetMapping("/{id}")
    public CreditCard getOneCreditCard(@PathVariable Long id){

        CreditCard creditCardlist = creditCardServ.findOneCreditCard(id).get();
        return creditCardlist ;
    }

    @PostMapping("/add")
    public ResponseEntity createCreditCard(@RequestBody CreditCard CreditCard){

        if (CreditCard != null && creditCardServ.findOneCreditCard(CreditCard.getId()) == null) {
            creditCardServ.create(CreditCard);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(409).build();
        }

    }

    @PutMapping("/update")
    public ResponseEntity updateCreditCard(@RequestBody CreditCard CreditCard){

        if (CreditCard != null && creditCardServ.findOneCreditCard(CreditCard.getId()) == null) {
            creditCardServ.create(CreditCard);
            //TODO: vérifier que c'est la bonne méthode à utiliser
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(409).build();
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCreditCard(@PathVariable Long id){

        if (creditCardServ.findOneCreditCard(id) != null) {
            creditCardServ.deleteCreditCard(id);
            return ResponseEntity.status(410).build();
        } else {
            return ResponseEntity.status(404).build();
        }

    }

}
