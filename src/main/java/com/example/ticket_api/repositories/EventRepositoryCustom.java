package com.example.ticket_api.repositories;

import com.example.ticket_api.entities.Event;

import java.util.List;

public interface  EventRepositoryCustom {
    List<Event> findEventsByQuery(String searchquery);
    List<Event> findEventsByNameOrCity(String name, String city);
}
