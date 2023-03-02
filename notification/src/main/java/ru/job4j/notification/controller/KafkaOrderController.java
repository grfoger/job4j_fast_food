package ru.job4j.notification.controller;

import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import ru.job4j.domain.model.Order;
import ru.job4j.notification.service.NotificationService;

@AllArgsConstructor
@Controller
public class KafkaOrderController {
    private final NotificationService service;

    @KafkaListener(topics = {"orders"})
    public void takeMessage(ConsumerRecord<Integer, Order> input) {
        service.save(input.value());
    }
}
