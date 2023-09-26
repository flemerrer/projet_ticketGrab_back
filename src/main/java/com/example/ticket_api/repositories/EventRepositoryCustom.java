package com.example.ticket_api.repositories;

import com.example.ticket_api.entities.Event;

import java.util.List;

public interface EventRepositoryCustom {
    List<Event> findEventsByNameAndCity(String eventName, String location);
}
