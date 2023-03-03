package ru.job4j.notification.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.domain.model.Order;
import ru.job4j.notification.service.NotificationService;

import java.io.IOException;
import java.util.List;


@AllArgsConstructor
@Controller
public class KafkaOrderController {
    private final NotificationService service;

    private KafkaTemplate<Integer, String> template;

    @KafkaListener(topics = {"orders"})
    public void takeMessage(ConsumerRecord<Integer, String> order) throws IOException {
        Order value = new ObjectMapper().readValue(order.value().getBytes(), Order.class);
        service.save(value);
    }

    @KafkaListener(topics = {"giveMe"})
    public void takeMessageGet(ConsumerRecord<Integer, String> take) throws IOException {
        if (take.value().equals("all"))  {
            List<Order> all = service.findAll();
            template.send("findAll", new ObjectMapper().writeValueAsString(all));
        }
    }
}
