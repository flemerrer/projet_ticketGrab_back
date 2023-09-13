package com.example.ticket_api;

import com.example.ticket_api.entities.Basket;
import com.example.ticket_api.entities.Event;
import com.example.ticket_api.entities.Order;
import com.example.ticket_api.entities.Ticket;
import com.example.ticket_api.services.BasketService;
import com.example.ticket_api.services.EventService;
import com.example.ticket_api.services.OrderService;
import com.example.ticket_api.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TicketFrontSpringApplication implements CommandLineRunner {

    @Autowired
    private TicketService ticketServ;
    @Autowired
    private EventService eventServ;
    @Autowired
    private BasketService basketServ;
    @Autowired
    private OrderService orderServ;
    
    public static void main(String[] args) {
        SpringApplication.run(TicketFrontSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Event event = new Event("Motocultor", LocalDate.now(), "3 rue Molière", "Paris", "");
        eventServ.create(event);

        Ticket ticket1 = new Ticket("pass WE", event, "link", 10000, true, false);
        Ticket ticket2 = new Ticket("pass jour 1", event, "link", 10000, true, false);
        ticketServ.create(ticket1);
        ticketServ.create(ticket2);

        List<Ticket> ticketList = new ArrayList<Ticket>();

        ticketList.add(ticket1);
        ticketList.add(ticket2);

        Basket basket = new Basket(ticketList);
        basketServ.create(basket);

        Order order = new Order(ticketList, LocalDate.now());
        orderServ.create(order);

        System.out.println(event +"\n"+ ticket1 +"\n"+ ticket2 +"\n"+ ticketList +"\n"+ basket +"\n"+ order);


    }
}
