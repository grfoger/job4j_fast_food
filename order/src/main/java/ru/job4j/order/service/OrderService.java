package ru.job4j.order.service;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.job4j.domain.model.Order;
import ru.job4j.domain.model.OrderStatus;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Service
public class OrderService {

    private KafkaTemplate<Integer, String> template;

    private List<Order> takeOrders;

    private OrderStatus currentStatus = OrderStatus.NOT_AVAILABLE;

    public OrderService(KafkaTemplate<Integer, String> template) {
        this.template = template;
    }


    public Order save(Order order) {
        try {
            template.send("orders", new ObjectMapper().writeValueAsString(order));
            template.send("preorder", new ObjectMapper().writeValueAsString(order));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("SENT");
        return order;
    }




    public List<Order> findAll() {
        template.send("giveMe", "all");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return takeOrders;
    }



    public OrderStatus getStatus() {
        return currentStatus;
    }
    @KafkaListener(topics = {"cooked_order"})
    public void getKafkaStatus(ConsumerRecord<Integer, String> status) throws IOException {
        currentStatus = new ObjectMapper().readValue(status.value().getBytes(), OrderStatus.class);
    }


    @KafkaListener(topics = {"findAll"})
    public void takeMessage(ConsumerRecord<Integer, String> orders) throws IOException {
        takeOrders = new ObjectMapper().readValue(orders.value(), new TypeReference<>() {
        });
    }
}
