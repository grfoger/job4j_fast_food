package ru.job4j.notification.service;

import org.springframework.stereotype.Service;
import ru.job4j.domain.model.Order;
@Service
public interface NotificationService {
    void save(Order value);
}
