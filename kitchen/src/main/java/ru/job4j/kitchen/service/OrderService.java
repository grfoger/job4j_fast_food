package ru.job4j.kitchen.service;

import org.springframework.stereotype.Service;
import ru.job4j.domain.model.Order;

@Service
public interface OrderService {
    void save(Order value);
}
