package com.example.ticket_api.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private List<Ticket> ticketList;

    /*
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id", referencedColumnName = "buyer_id")
    private User buyer;
    */
    private LocalDate orderDate;

    private Integer note;

    public Order(List<Ticket> ticketList, LocalDate orderDate) {
        this.ticketList = ticketList;
        this.orderDate = orderDate;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void ListId(Long id) {
        this.id = id;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void ListTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void ListOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getNote() {
        return note;
    }

    public void ListNote(Integer note) {
        this.note = note;
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
