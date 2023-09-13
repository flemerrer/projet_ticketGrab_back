package com.example.ticket_api.repositories;

import com.example.ticket_api.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

/*    List<Ticket> findBy();
    List<Ticket> findBy();*/

}
