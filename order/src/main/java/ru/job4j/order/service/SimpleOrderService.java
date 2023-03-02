package ru.job4j.order.service;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.job4j.domain.model.Order;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SimpleOrderService implements OrderService {

    private KafkaTemplate<Integer, Order> template;
    @Override
    public Order save(Order order) {
        System.out.println("BEFORE SEND");
        template.send("orders", order);
        System.out.println("AFTER SEND");
        return order;
    }

    @Override
    public Order delete(Order order) {
        return null;
    }

    @Override
    public Optional<Order> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Order> findAll() {
        return null;
    }
}
