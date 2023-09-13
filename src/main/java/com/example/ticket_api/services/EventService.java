package com.example.ticket_api.services;

import com.example.ticket_api.entities.Event;
import com.example.ticket_api.entities.dto.EventDTO;
import com.example.ticket_api.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepo;

    public List<Event> findAllEvents() {
        return eventRepo.findAll();
    }

    public List<EventDTO> fetchAllDTOEvents() {
        return findAllEvents().stream().map(event -> event.toDto()).toList();
    };

    public List<Event> FindEventsByName(String name) {
        return eventRepo.findByNameContainsIgnoreCase(name);
    }

    public Optional<Event> findOneEvent(Long id) {
        return eventRepo.findById(id);
    }

    public void create(Event event) {
        eventRepo.save(event);
    }
    
    public void deleteEvent(Long id) {
        eventRepo.deleteById(id);
    }
    
/*
    public void deleteAllEvents() {
        EventRepo.deleteAll();
    }
*/

}
