package com.example.ticket_front.services;

import com.example.ticket_front.entities.Order;
import com.example.ticket_front.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository OrderRepo;

    public List<Order> findAllOrders() {
        return OrderRepo.findAll();
    }
    
    public Optional<Order> findOrderById(Long id) { 
        return OrderRepo.findById(id);
    }

    public void create(Order Order) {
        OrderRepo.save(Order);
    }
    
    public void deleteturorialById(Long id) {
        OrderRepo.deleteById(id);
    }
    
/*
    public void deleteAllOrders() {
        OrderRepo.deleteAll();
    }
*/

}
