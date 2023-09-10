package com.example.ticket_front.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="baskets")
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "basket")
    private Set<Ticket> ticketSet;

    /*
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User buyer;
*/
    public Basket(Set<Ticket> ticketSet /*, User buyer*/) {
        this.ticketSet = ticketSet;
      /*  this.buyer = buyer;*/
    }

    public Basket() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Ticket> getTicketSet() {
        return ticketSet;
    }

    public void setTicketSet(Set<Ticket> ticket) {
        this.ticketSet = ticket;
    }
/*
    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }
    */
}
