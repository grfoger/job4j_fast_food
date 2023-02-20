package ru.job4j.order.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.domain.model.Order;
import ru.job4j.domain.model.OrderStatus;
import ru.job4j.order.service.OrderService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/order")

public class OrderController {
    private final OrderService orders;

    @GetMapping("/")
    public List<Order> findAll() {
        return orders.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable int id) {
        Order order = orders.findById(id);
        return new ResponseEntity<>(order, order == null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping("/status/{id}")
    public ResponseEntity<OrderStatus> getStatus(@PathVariable int id) {
        Order order = orders.findById(id);
        return new ResponseEntity<>(order.getStatus(), order == null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Order> delete(@PathVariable int id) {
        Order order = new Order();
        order.setId(id);
        orders.delete(order);
        return ResponseEntity.ok().build();
    }
}
