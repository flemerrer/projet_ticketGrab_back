package com.example.ticket_api.controllers;

import com.example.ticket_api.entities.Ticket;
import com.example.ticket_api.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    TicketService ticketServ;

    @GetMapping({"", "/all"})
    public List<Ticket> getAllTickets(){

        List<Ticket> tickelist = ticketServ.findAllTickets();
        return tickelist;
    }

    @GetMapping("/{id}")
    public Ticket getOneTicket(@PathVariable Long id){

        Ticket tickelist = ticketServ.findTicketById(id).get();
        return tickelist ;
    }



}
