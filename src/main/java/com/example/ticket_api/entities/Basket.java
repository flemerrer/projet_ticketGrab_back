package com.example.ticket_api.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="baskets")
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany (mappedBy = "baskets")
//    @JoinTable(name="tickets", joinColumns = @JoinColumn(name="ticket_id"))
    private List<Ticket> tickets;

    @OneToOne(mappedBy = "basket")
    private User user;


    /*
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User buyer;
*/
    public Basket(List<Ticket> ticketList /*, User buyer*/) {
        this.tickets = ticketList;
      /*  this.buyer = buyer;*/
    }

    public Basket() {
    }

    public Long getId() {
        return id;
    }

    public void ListId(Long id) {
        this.id = id;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void ListTicketList(List<Ticket> ticket) {
        this.tickets = ticket;
    }
/*
    public User getBuyer() {
        return buyer;
    }

    public void ListBuyer(User buyer) {
        this.buyer = buyer;
    }
    */
}
