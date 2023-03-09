package ru.job4j.order.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.domain.model.Order;
import ru.job4j.domain.model.OrderStatus;
import ru.job4j.order.service.OrderService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orders;

    @GetMapping("/")
    public List<Order> findAll() {
        return orders.findAll();
    }

    @GetMapping("/status")
    public OrderStatus getStatus() {
        return orders.getStatus();
    }



    @PostMapping("/")
    public ResponseEntity<Order> create(@RequestBody Order order) {
        return new ResponseEntity<>(orders.save(order), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Void> update(@RequestBody Order order) {
        orders.save(order);
        return ResponseEntity.ok().build();
    }

}
