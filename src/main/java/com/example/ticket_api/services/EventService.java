package com.example.ticket_api.services;

import com.example.ticket_api.entities.Event;
import com.example.ticket_api.entities.dto.EventDto;
import com.example.ticket_api.entities.dto.EventDtoCity;
import com.example.ticket_api.repositories.EventRepository;
import com.example.ticket_api.repositories.EventRepositoryCustomImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepo;

    @Autowired
    private EventRepositoryCustomImpl eventRepoCustom;

    public List<EventDto> searchEventsByNameOrCity(String name, String city){
        return eventRepoCustom.findEventsByNameOrCity(name, city).stream().map(event -> event.toDto()).toList();
    }

    public List<EventDto> searchEventsByQuery(String searchquery){
        return eventRepoCustom.findEventsByQuery(searchquery).stream().map(event -> event.toDto()).toList();
    }

    public List<Event> findAllEvents() {
        return eventRepo.findAll();
    }

    public List<EventDto> fetchAllDTOEvents() {
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

    public HashSet<String> getAllCities() {
        List<EventDtoCity> citiesList = findAllEvents().stream().map(event -> event.toDtoCity()).toList();
        HashSet<String> cities = new HashSet<String>();
        for (EventDtoCity c : citiesList) {
            cities.add(c.getCity());
        }
        return cities;
    }
    
/*
    public void deleteAllEvents() {
        EventRepo.deleteAll();
    }
*/

}
