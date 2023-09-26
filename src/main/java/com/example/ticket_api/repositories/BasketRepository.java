package com.example.ticket_api.repositories;

import com.example.ticket_api.entities.Basket;
import com.example.ticket_api.entities.Ticket;
import com.example.ticket_api.entities.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Long> {

//    public List<Ticket> findByBasket(Basket basket);
    public Basket findByUser(User user);
    public Basket findByUserEmail(String email);

//    public Basket findByUser(UserDto user);

//    public String delete(Optional<Basket> basket);
}
