package ru.job4j.notification.repository;

import ru.job4j.domain.model.Order;

public interface NotificationRepository {
    void save(Order value);
}
