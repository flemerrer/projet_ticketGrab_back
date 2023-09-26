package com.example.ticket_api.entities;

import com.example.ticket_api.entities.dto.EventDTO;
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
    private List<Ticket> tickets;

//    @OneToMany(mappedBy = "event")
//    private List<Ticket> ticketList;


//    @OneToMany(mappedBy = "event")
//    private List<Ticket> ticketList;


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

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public List<Ticket> getTicketList() {
        return tickets;
    }


    public void setTicketList(List<Ticket> ticket) {
        this.tickets = ticket;
    }

//    public List<Ticket> getTicketList() {
//        return ticketList;
//    }

//    public void setTicketList(List<Ticket> ticket) {
//        this.ticketList = ticket;
//    }


//    public List<Ticket> getTicketList() {
//        return ticketList;
//    }

//    public void setTicketList(List<Ticket> ticket) {
//        this.ticketList = ticket;
//    }


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
                ", name=" + name +

                ", tickets=" + tickets +

                //", tickets=" + ticketList +
                ", date=" + date +
                ", location='" + location + '\'' +
                ", city='" + city + '\'' +
                ", website='" + website + '\'' +
                '}';
    }

    public EventDTO toDto() {

        EventDTO eventDto = new EventDTO();
        eventDto.setId(this.getId());
        eventDto.setName(this.getName());
        eventDto.setDate(this.getDate());
        eventDto.setCity(this.getCity());

        return eventDto;
    }
}
