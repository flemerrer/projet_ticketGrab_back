package com.example.ticket_api.repositories;

import com.example.ticket_api.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByNameContainsIgnoreCase(String title);

//    List<Event> findAllByDate

/*    List<Ticket> findBy();
    List<Ticket> findBy();*/

}
