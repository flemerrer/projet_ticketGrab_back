package com.example.ticket_front;

import com.example.ticket_front.entities.Basket;
import com.example.ticket_front.entities.Event;
import com.example.ticket_front.entities.Order;
import com.example.ticket_front.entities.Ticket;
import com.example.ticket_front.services.BasketService;
import com.example.ticket_front.services.EventService;
import com.example.ticket_front.services.OrderService;
import com.example.ticket_front.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Set;

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

        TicketService ticketservice;


        Event event = new Event(LocalDate.now(), "3 rue Molière", "Paris", null);
        eventServ.create(event);

        Ticket ticket1 = new Ticket("pass WE", event, null, 10000, true, false);
        Ticket ticket2 = new Ticket("pass jour 1", event, null, 10000, true, false);
        ticketServ.create(ticket1);
        ticketServ.create(ticket2);

        Set<Ticket> ticketSet = null;
        ticketSet.add(ticket1);
        ticketSet.add(ticket2);
        Basket basket = new Basket(ticketSet);
        basketServ.create(basket);

        Order order = new Order(basket, basket.getTicketSet(), LocalDate.now(), null);
        orderServ.create(order);

        System.out.println(event +"\n"+ ticket1 +"\n"+ ticket2 +"\n"+ ticketSet +"\n"+ basket +"\n"+ order);

    }
}
