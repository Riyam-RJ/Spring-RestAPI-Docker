package com.webshop.backend.services;

import com.webshop.backend.entity.Order;
import com.webshop.backend.repositories.OrderRepo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderService {

    private final OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public List<Order> getOrders() {
        return orderRepo.findAll();
    }

    public List<Order> getOrderByCustomerId(Long id) {
        return orderRepo.findAllOrdesByCustomerId(id);
    }


}
