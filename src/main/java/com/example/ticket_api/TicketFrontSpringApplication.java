package com.example.ticket_api;

import com.example.ticket_api.entities.Ticket;
import com.example.ticket_api.repositories.TicketRepository;
import com.example.ticket_api.services.BasketService;
import com.example.ticket_api.services.EventService;
import com.example.ticket_api.services.OrderService;
import com.example.ticket_api.services.TicketService;
import com.example.ticket_api.entities.User;
import com.example.ticket_api.repositories.UserRepository;
import com.example.ticket_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(TicketFrontSpringApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                String prenom = "Al";
                String nom = "Hct";
                String email = "AlHct";
                String mdp = "blabla";
                if (userRepository.findUserByEmailAndPassword(email, mdp) == null) {
//                    User user = new User(email, passwordEncoder.encode(mdp));
                    User user = new User(prenom, nom, email, mdp);
                    userRepository.save(user);
                }
            }

        };
    }


    @Override
    public void run(String... args) throws Exception {
//        Event event = new Event("Motocultor", LocalDate.now(), "3 rue Molière", "Paris", "");
//        eventServ.create(event);
//
//        Ticket ticket1 = new Ticket("pass WE", event, "link", 10000, true, false);
//        Ticket ticket2 = new Ticket("pass jour 1", event, "link", 10000, true, false);
//        ticketServ.create(ticket1);
//        ticketServ.create(ticket2);
//
//        List<Ticket> ticketList = new ArrayList<Ticket>();
//
//        ticketList.add(ticket1);
//        ticketList.add(ticket2);
//
//        Basket basket = new Basket(ticketList);
//        basketServ.create(basket);
//
//        Order order = new Order(ticketList, LocalDate.now());
//        orderServ.create(order);
//
//        System.out.println(event +"\n"+ ticket1 +"\n"+ ticket2 +"\n"+ ticketList +"\n"+ basket +"\n"+ order);


    }
}
