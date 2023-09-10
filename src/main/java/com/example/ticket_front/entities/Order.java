package com.example.ticket_front.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="basket_id", referencedColumnName = "id")
    private Basket basket;

    @OneToMany(mappedBy = "order")
    private Set<Ticket> ticketSet;

    /*
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id", referencedColumnName = "buyer_id")
    private User buyer;
    */
    private LocalDate orderDate;

    private Integer note;

    public Order(Basket basket, Set<Ticket> ticketSet, LocalDate orderDate, Integer note) {
        this.basket = basket;
        this.ticketSet = ticketSet;
        this.orderDate = orderDate;
        this.note = note;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public Set<Ticket> getTicketSet() {
        return ticketSet;
    }

    public void setTicketSet(Set<Ticket> ticketList) {
        this.ticketSet = ticketList;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
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
