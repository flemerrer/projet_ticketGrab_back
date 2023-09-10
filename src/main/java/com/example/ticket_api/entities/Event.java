package com.example.ticket_api.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "event")
    private List<Ticket> ticketList;

    @Temporal(TemporalType.DATE)
    private LocalDate date;

    private String location;

    private String city;

    private String website;

    public Event(String name, LocalDate date, String location, String city, String website) {
        this.name = name;
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

    public void ListId(Long id) {
        this.id = id;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void ListTicketList(List<Ticket> ticket) {
        this.ticketList = ticket;
    }

    public LocalDate getDate() {
        return date;
    }

    public void ListDate(LocalDate date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void ListLocation(String location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void ListCity(String city) {
        this.city = city;
    }

    public String getWebsite() {
        return website;
    }

    public void ListWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name=" + name +
                ", tickets=" + ticketList +
                ", date=" + date +
                ", location='" + location + '\'' +
                ", city='" + city + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}
