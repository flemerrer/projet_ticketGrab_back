package com.example.ticket_front.entities;

import jakarta.persistence.*;

@Entity
@Table(name="credit_cards")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
  /*
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id", referencedColumnName = "owner_id")
    private User owner;
    */
    private Long blueprint;

    private String ownerName;

    private String expirationDate;

    public CreditCard(Long blueprint, String ownerName, String expirationDate) {
        this.blueprint = blueprint;
        this.ownerName = ownerName;
        this.expirationDate = expirationDate;
    }

    public CreditCard() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBlueprint() {
        return blueprint;
    }

    public void setBlueprint(Long blueprint) {
        this.blueprint = blueprint;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
/*
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
    */
}
