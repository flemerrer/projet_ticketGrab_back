package com.example.ticket_api.services;

import com.example.ticket_api.entities.Ticket;
import com.example.ticket_api.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepo;

    public List<Ticket> findAllTickets() {
        return ticketRepo.findAll();
    }

    public List<Ticket> FindTicket(String name) {
        return ticketRepo.findByNameContainsIgnoreCase(name);
    }

    public Optional<Ticket> findTicketById(Long id) {
        return ticketRepo.findById(id);
    }

    public void create(Ticket Ticket) {
        ticketRepo.save(Ticket);
    }

    public void deleteTicketById(Long id) {
        ticketRepo.deleteById(id);
    }

/*
    public void deleteAllTickets() {
        ticketRepo.deleteAll();
    }
*/

}
