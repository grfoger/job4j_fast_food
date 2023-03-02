package ru.job4j.notification.repository;

import ru.job4j.domain.model.Order;

import java.util.List;

public interface NotificationRepository {
    void save(Order value);

    List<Order> findAll();
}
