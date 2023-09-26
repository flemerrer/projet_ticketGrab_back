package com.example.ticket_api.entities;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name="tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String infos;

    @ManyToOne
    private Event event;

    @ManyToMany
    @JoinTable(name="basket_ticket_joint")
    private List<Basket> baskets;

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

    public Ticket(String infos, Event event, String imageLink, int price, boolean onSale, boolean isSold) {
        this.infos = infos;
        this.event = event;
        this.imageLink = imageLink;
        this.price = price;
        this.onSale = onSale;
        this.isSold = isSold;
    }

    public Ticket() {
    }

    public Ticket(String name, String imageLink, int price, boolean onSale, boolean isSold) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getInfos() {
        return infos;
    }

    public void setInfos(String infos) {
        this.infos = infos;

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

    public void setOnSale() {
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
                ", name=" + infos +
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