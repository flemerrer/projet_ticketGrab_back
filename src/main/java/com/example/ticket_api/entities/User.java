package com.example.ticket_api.entities;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique=true)
    private String email;
    private String password;
    private Boolean isAdmin;
    private Integer soldTicketsNumber;

    @OneToMany(mappedBy = "user")
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "user")
    private List<CreditCard> cards;

    @OneToOne
    private Basket basket;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    public User() {
    }

    public User(String firstNameUser, String lastNameUser, String emailUser, String passwordUser) {
        this.firstName = firstNameUser;
        this.lastName = lastNameUser;
        this.email = emailUser;
        this.password = passwordUser;
        this.soldTicketsNumber = 0;
        this.isAdmin= false;
    }

    public User(String email) {
        this.email = email;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<CreditCard> getCards() {
        return cards;
    }

    public void setCards(List<CreditCard> cards) {
        this.cards = cards;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long idUser) {
        this.id = idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstNameUser) {
        this.firstName = firstNameUser;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastNameUser) {
        this.lastName = lastNameUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String emailUser) {
        this.email = emailUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passwordUser) {
        this.password = passwordUser;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Integer getSoldTicketsNumber() {
        return soldTicketsNumber;
    }

    public void setSoldTicketsNumber(Integer soldTicketsNumber) {
        this.soldTicketsNumber = soldTicketsNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + id +
                ", firstNameUser='" + firstName + '\'' +
                ", lastNameUser='" + lastName + '\'' +
                ", emailUser='" + email + '\'' +
                ", passwordUser='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                ", soldTicketsNumber=" + soldTicketsNumber +
                '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities= new ArrayList<>() ;

        authorities.add(new SimpleGrantedAuthority("USER"));
//        authorities.add(new SimpleGrantedAuthority("ADMIN"));

        return authorities;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
