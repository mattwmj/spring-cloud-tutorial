package com.smec.eis.ecs.tutorial.order;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping("/{itemName}")
    public Long placeOrder(@PathVariable String itemName) {
        Order order = new Order();
        order.setItemName(itemName);
        order.setCreateDate(new Date());
        order = orderRepository.save(order);
        return order.getId();
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderRepository.findById(id).orElse(null);
    }
}
