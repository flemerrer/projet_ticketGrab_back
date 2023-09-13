package com.example.ticket_api.repositories;

import com.example.ticket_api.entities.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {

/*    List<Ticket> findBy();
    List<Ticket> findBy();*/

}
