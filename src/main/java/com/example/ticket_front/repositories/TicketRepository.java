package com.example.ticket_front.repositories;

import com.example.ticket_front.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByTitleContainsIgnoreCase(String title);

/*    List<Ticket> findBy();
    List<Ticket> findBy();*/

}
