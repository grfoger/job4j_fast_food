package ru.job4j.order.service;

import org.springframework.stereotype.Service;

import ru.job4j.domain.model.Order;

import java.util.List;

@Service
public interface OrderService {
    Order save(Order order);
    Order delete(Order order);
    Order findById(int id);
    List<Order> findAll();
}
