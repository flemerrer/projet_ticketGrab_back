package com.example.ticket_api.repositories;

import com.example.ticket_api.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
//    List<Ticket> findByNameContainsIgnoreCase(String title);

    @Override
    List<Ticket> findAll();



    /*    List<Ticket> findBy();
    List<Ticket> findBy();*/

}
