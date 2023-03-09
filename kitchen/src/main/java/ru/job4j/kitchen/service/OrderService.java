package ru.job4j.kitchen.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.job4j.domain.model.Order;
import ru.job4j.domain.model.OrderStatus;
import ru.job4j.kitchen.model.OrderDTO;
import ru.job4j.kitchen.repository.OrderRepository;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


@Service
@AllArgsConstructor

public class OrderService {
    private final OrderRepository repository;
    private final KafkaTemplate<Integer, String> template;

    public void save(Order value) {
        OrderDTO order = repository.save(new OrderDTO(0, value.getOrderNumber(), OrderStatus.CONFIRMED.getStatusCode()));
        cookOrder(value, order.getId());
    }

    private void cookOrder(Order order, int orderId) {
        try {
        if ((int) System.currentTimeMillis() % 10 != 1) {
                Callable<String> cookTask = () -> {
                    Thread.sleep(60_000);
                    return "Cooked!";
                };
                FutureTask<String> future = new FutureTask<>(cookTask);
                new Thread(future).start();
                System.out.println(future.get());
                order.setStatus(OrderStatus.SENT);
                repository.save(new OrderDTO(orderId, order.getOrderNumber(), order.getStatus().getStatusCode()));
                template.send("cooked_order", new ObjectMapper().writeValueAsString(OrderStatus.DELIVERED));
        } else {
            template.send("cooked_order", new ObjectMapper().writeValueAsString(OrderStatus.CANCELED));
        }
        } catch (JsonProcessingException | ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
