package ru.job4j.kitchen.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.job4j.domain.model.Order;
import ru.job4j.domain.model.OrderStatus;
import ru.job4j.kitchen.model.OrderDTO;
import ru.job4j.kitchen.repository.OrderRepository;

@Service
@AllArgsConstructor
public class SimpleOrderService implements OrderService{

    private final OrderRepository repository;
    @Override
    public void save(Order value) {
        OrderDTO order = repository.save(new OrderDTO(0, value.getOrderNumber(), OrderStatus.CONFIRMED.getStatusCode()));
        cookOrder(order);
    }

    private void cookOrder(OrderDTO order) {
    }
}
