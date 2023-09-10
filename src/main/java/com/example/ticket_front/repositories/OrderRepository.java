package com.example.ticket_front.repositories;

import com.example.ticket_front.entities.Order;
import com.example.ticket_front.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

/*    List<Ticket> findBy();
    List<Ticket> findBy();*/

}
