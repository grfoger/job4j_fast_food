package ru.job4j.order.service;

import org.springframework.stereotype.Service;

import ru.job4j.domain.model.Order;
import ru.job4j.domain.model.OrderStatus;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderService {
    Order save(Order order);
    Order delete(Order order);
    Optional<Order> findById(int id);
    List<Order> findAll();

    OrderStatus getStatus();
}
