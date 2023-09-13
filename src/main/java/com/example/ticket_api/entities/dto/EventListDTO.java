package com.example.ticket_api.entities.dto;

import com.example.ticket_api.entities.Ticket;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

public class EventListDTO {

    private Long id;
    private String name;
    private LocalDate date;
    private String city;

    public EventListDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
