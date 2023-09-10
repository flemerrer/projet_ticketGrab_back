package com.example.ticket_front.services;

import com.example.ticket_front.entities.Ticket;
import com.example.ticket_front.repositories.TicketRepository;
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

    public List<Ticket> FindTicket(String title) {
        return ticketRepo.findByTitleContainsIgnoreCase(title);
    }

    public Optional<Ticket> findTicketById(Long id) {
        return ticketRepo.findById(id);
    }

    public void create(Ticket Ticket) {
        ticketRepo.save(Ticket);
    }

    public void deleteturorialById(Long id) {
        ticketRepo.deleteById(id);
    }

/*
    public void deleteAllTickets() {
        ticketRepo.deleteAll();
    }
*/

}
