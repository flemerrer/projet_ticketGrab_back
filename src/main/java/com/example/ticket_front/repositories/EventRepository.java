package com.example.ticket_front.repositories;

import com.example.ticket_front.entities.Event;
import com.example.ticket_front.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByTitleContainsIgnoreCase(String title);

/*    List<Ticket> findBy();
    List<Ticket> findBy();*/

}
