package com.example.ticket_api.controllers;

import com.example.ticket_api.entities.Event;
import com.example.ticket_api.entities.Ticket;
import com.example.ticket_api.entities.dto.EventDTO;
import com.example.ticket_api.entities.dto.TicketDto;
import com.example.ticket_api.services.EventService;
import com.example.ticket_api.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/tickets") //Marche bien en JSON
public class TicketController {

    @Autowired
    TicketService ticketServ;

    @Autowired
    EventService eventServ;

    @GetMapping({"", "/all"}) //Marche bien en JSON
    public List<Ticket> getAllTickets(){

        List<Ticket> tickelist = ticketServ.findAllTickets();
        return tickelist;
    }

    @GetMapping("/{id}") //Marche bien en JSON
    public Ticket getOneTicket(@PathVariable Long id){

        Ticket ticketlist = ticketServ.findOneTicket(id).get();
        return ticketlist ;
    }

    @PostMapping("/add")
    public ResponseEntity createTicket(@RequestBody Ticket ticket){

        if (ticket != null) {
            ticketServ.create(ticket);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(409).build();
        }




//        try {
//            Event event = eventServ.findOneEvent(dto.getEventId()).get();
//
//            Ticket newTicket = new Ticket(dto.getInfos(), event,  dto.getImageLink(), dto.getPrice(), true, false);
//            ticketServ.create(newTicket);
//            return ResponseEntity.status(409).build();
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().build();
//        }
    }

    @PutMapping("/update")
    public ResponseEntity updateTicket(@RequestBody Ticket ticket){

        if (ticket != null && ticketServ.findOneTicket(ticket.getId()) == null) {
            ticketServ.create(ticket);
            //TODO: vérifier que c'est la bonne méthode à utiliser
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(409).build();
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTicket(@PathVariable Long id){

        if (ticketServ.findOneTicket(id) != null) {
            ticketServ.deleteTicket(id);
            return ResponseEntity.status(410).build();
        } else {
            return ResponseEntity.status(404).build();
        }

    }

}
