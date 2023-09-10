package com.example.ticket_front.repositories;

import com.example.ticket_front.entities.CreditCard;
import com.example.ticket_front.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {

/*    List<Ticket> findBy();
    List<Ticket> findBy();*/

}
