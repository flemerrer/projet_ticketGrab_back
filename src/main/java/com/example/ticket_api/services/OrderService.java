package com.example.ticket_api.services;

import com.example.ticket_api.entities.Order;
import com.example.ticket_api.repositories.OrderRepository;
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
    
    public Optional<Order> findOneOrder(Long id) {
        return OrderRepo.findById(id);
    }

    public void create(Order Order) {
        OrderRepo.save(Order);
    }
    
    public void deleteOrder(Long id) {
        OrderRepo.deleteById(id);
    }
    
/*
    public void deleteAllOrders() {
        OrderRepo.deleteAll();
    }
*/

}
