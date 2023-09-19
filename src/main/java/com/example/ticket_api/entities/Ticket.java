package com.example.ticket_api.entities;

import jakarta.persistence.*;
import org.hibernate.mapping.List;
import org.hibernate.mapping.Set;


@Entity
@Table(name="tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    private Event event;

    @ManyToMany
    private Set<Basket> baskets;

    @ManyToOne
    private Order order;

    @ManyToOne
    private User user;

/*
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User seller;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id", referencedColumnName = "buyer_id")
    private User buyer;
*/

    private String imageLink;

    //stock in cents to avoid rounding errors
    private int price;

    private boolean onSale;

    private boolean isSold;

    public Ticket(String name, Event event, String imageLink, int price, boolean onSale, boolean isSold) {
        this.name = name;
        this.event = event;
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
                ", name=" + name +
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