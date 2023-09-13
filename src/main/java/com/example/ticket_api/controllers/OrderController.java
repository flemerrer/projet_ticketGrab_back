package com.example.ticket_api.controllers;

import com.example.ticket_api.entities.Order;
import com.example.ticket_api.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    
    @Autowired
    OrderService orderServ;

    @GetMapping({"", "/all"})
    public List<Order> getAllOrders(){

        List<Order> orderlist = orderServ.findAllOrders();
        return orderlist;
    }


    @GetMapping("/{id}")
    public Order getOneOrder(@PathVariable Long id){

        Order orderlist = orderServ.findOneOrder(id).get();
        return orderlist ;
    }

    @PostMapping("/add")
    public ResponseEntity createOrder(@RequestBody Order Order){

        if (Order != null && orderServ.findOneOrder(Order.getId()) == null) {
            orderServ.create(Order);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(409).build();
        }

    }

    @PutMapping("/update")
    public ResponseEntity updateOrder(@RequestBody Order Order){

        if (Order != null && orderServ.findOneOrder(Order.getId()) == null) {
            orderServ.create(Order);
            //TODO: vérifier que c'est la bonne méthode à utiliser
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(409).build();
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteOrder(@PathVariable Long id){

        if (orderServ.findOneOrder(id) != null) {
            orderServ.deleteOrder(id);
            return ResponseEntity.status(410).build();
        } else {
            return ResponseEntity.status(404).build();
        }

    }

}
