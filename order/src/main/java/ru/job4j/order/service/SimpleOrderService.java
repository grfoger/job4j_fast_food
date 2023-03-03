package ru.job4j.order.service;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.job4j.domain.model.Order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SimpleOrderService implements OrderService {

    private KafkaTemplate<Integer, String> template;

    private List<Order> takeOrders = new ArrayList<>();
    @Override
    public Order save(Order order) {
        try {
            template.send("orders", new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(order));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("SENT");
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
        template.send("giveMe", "all");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return takeOrders;
    }

    @KafkaListener(topics = {"findAll"})
    public void takeMessage(ConsumerRecord<Integer, String> orders) throws IOException {
        takeOrders = new ObjectMapper().readValue(orders.value(), new TypeReference<>() {
        });
    }
}
