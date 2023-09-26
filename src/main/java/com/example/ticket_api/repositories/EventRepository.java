package com.example.ticket_api.repositories;

import com.example.ticket_api.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>, EventRepositoryCustom {

    List<Event> findByNameContainsIgnoreCase(String title);

//    List<Event> findBy NameContainsOrCityContainsIgnoreCase();

}
