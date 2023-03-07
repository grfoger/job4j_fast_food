package ru.job4j.kitchen.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import ru.job4j.domain.model.Order;
import ru.job4j.kitchen.service.OrderService;

import java.io.IOException;

@Controller
@AllArgsConstructor
public class KafkaOrderController {
    private final OrderService service;

    private KafkaTemplate<Integer, String> template;

    @KafkaListener(topics = {"preorder"})
    public void takeMessage(ConsumerRecord<Integer, String> order) throws IOException {
        Order value = new ObjectMapper().readValue(order.value().getBytes(), Order.class);
        service.save(value);
    }
}
