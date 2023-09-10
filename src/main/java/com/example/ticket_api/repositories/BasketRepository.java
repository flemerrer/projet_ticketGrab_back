package com.example.ticket_api.repositories;

import com.example.ticket_api.entities.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Long> {

/*    List<Ticket> findBy();
    List<Ticket> findBy();*/

}
