package com.example.ticket_front.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "event")
    private Set<Ticket> ticketSet;

    private LocalDate date;

    private String location;

    private String city;

    private String website;

    public Event(LocalDate date, String location, String city, String website) {
        this.date = date;
        this.location = location;
        this.city = city;
        this.website = website;
    }

    public Event() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Ticket> getTicketSet() {
        return ticketSet;
    }

    public void setTicketSet(Set<Ticket> ticket) {
        this.ticketSet = ticket;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", ticket=" + ticketSet +
                ", date=" + date +
                ", location='" + location + '\'' +
                ", city='" + city + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}
