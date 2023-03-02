package ru.job4j.notification.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.domain.model.Order;

import java.util.List;
@Repository
public interface NotificationRepository {
    void save(Order value);

    List<Order> findAll();
}
