package com.example.ticket_api.controllers;

import com.example.ticket_api.entities.Ticket;
import com.example.ticket_api.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
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

    @PostMapping("/add")
    public ResponseEntity createTicket(@RequestBody Ticket ticket){

        if (ticket != null && ticketServ.findTicketById(ticket.getId()) == null) {
            ticketServ.create(ticket);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(409).build();
        }

    }

    @PutMapping("/update")
    public ResponseEntity updateTicket(@RequestBody Ticket ticket){

        if (ticket != null && ticketServ.findTicketById(ticket.getId()) == null) {
            ticketServ.create(ticket);
            //TODO: vérifier que c'est la bonne méthode à utiliser
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(409).build();
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTicket(@PathVariable Long id){

        if (ticketServ.findTicketById(id) != null) {
            ticketServ.deleteTicketById(id);
            return ResponseEntity.status(410).build();
        } else {
            return ResponseEntity.status(404).build();
        }

    }

}
