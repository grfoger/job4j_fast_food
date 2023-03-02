package ru.job4j.notification.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.domain.model.Order;
import ru.job4j.notification.repository.NotificationRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class SimpleNotificationService implements NotificationService {

   private final NotificationRepository repository;
    @Override
    public void save(Order value) {
        repository.save(value);
    }

    @Override
    public List<Order> findAll() {
        return repository.findAll();
    }
}
