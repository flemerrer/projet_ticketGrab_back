package com.example.ticket_front.repositories;

import com.example.ticket_front.entities.Basket;
import com.example.ticket_front.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Long> {

/*    List<Ticket> findBy();
    List<Ticket> findBy();*/

}
