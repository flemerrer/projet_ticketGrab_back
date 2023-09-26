package com.example.ticket_api.services;

import com.example.ticket_api.entities.Event;
import com.example.ticket_api.entities.dto.EventDto;
import com.example.ticket_api.entities.dto.CityDto;
import com.example.ticket_api.repositories.EventRepository;
import com.example.ticket_api.repositories.EventRepositoryCustomImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public List<CityDto> getAllCities() {

        List<Event> allEvents = findAllEvents();
        HashSet<String> cities = new HashSet<String>();
        for (Event e : allEvents) {
            cities.add(e.getCity());
        }

        List<CityDto> cityDtoList = new ArrayList<CityDto>();

        Long i = 1L;

        for (String c : cities) {
            CityDto newCity = new CityDto();
            newCity.setId(i++);
            newCity.setName(c);
            cityDtoList.add(newCity);
        }

        return cityDtoList;
    }
    
/*
    public void deleteAllEvents() {
        EventRepo.deleteAll();
    }
*/

}
