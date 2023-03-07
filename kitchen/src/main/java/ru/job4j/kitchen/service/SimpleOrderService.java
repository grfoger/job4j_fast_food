package ru.job4j.kitchen.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.job4j.domain.model.Order;
import ru.job4j.domain.model.OrderStatus;
import ru.job4j.kitchen.model.OrderDTO;
import ru.job4j.kitchen.repository.OrderRepository;

@Service
@AllArgsConstructor
public class SimpleOrderService implements OrderService {
    private final OrderRepository repository;
    private final KafkaTemplate<Integer, String> template;
    @Override
    public void save(Order value) {
        OrderDTO order = repository.save(new OrderDTO(0, value.getOrderNumber(), OrderStatus.CONFIRMED.getStatusCode()));
        cookOrder(value, order.getId());
    }

    private void cookOrder(Order order, int orderId) {
        try {
            Thread.sleep(10);
        order.setStatus(OrderStatus.SENT);
        repository.save(new OrderDTO(orderId, order.getOrderNumber(), order.getStatus().getStatusCode()));
        template.send("status", new ObjectMapper().writeValueAsString(order));
        } catch (InterruptedException | JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}
