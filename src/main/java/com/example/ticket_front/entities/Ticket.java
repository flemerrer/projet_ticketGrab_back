package com.example.ticket_front.entities;

import jakarta.persistence.*;

@Entity
@Table(name="tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="event_id", nullable=false)
    private Event event;

/*
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User seller;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User buyer;
*/

    private String imageLink;

    //stock in cents to avoid rounding errors
    private int price;

    private boolean onSale;

    private boolean isSold;

    public Ticket(Long id, Event event, /*User seller, User buyer,*/ String imageLink, int price, boolean onSale, boolean isSold) {
        this.id = id;
        this.event = event;
//        this.seller = seller;
//        this.buyer = buyer;
        this.imageLink = imageLink;
        this.price = price;
        this.onSale = onSale;
        this.isSold = isSold;
    }

    public Ticket() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

/*    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }*/

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", event=" + event +
/*                ", seller=" + seller +
                ", buyer=" + buyer +*/
                ", imageLink='" + imageLink + '\'' +
                ", price=" + price +
                ", onSale=" + onSale +
                ", isSold=" + isSold +
                '}';
    }
}