package ru.job4j.notification.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.domain.model.Order;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class SimpleNotificationStore implements NotificationRepository {
    private final Map<Integer, Order> store = new ConcurrentHashMap<>();
    private final AtomicInteger count = new AtomicInteger(0);
    @Override
    public void save(Order value) {
        System.out.println("Delivered order " + value.getOrderNumber() + " with status " + value.getStatus());
        store.put(count.incrementAndGet(), value);
    }

    @Override
    public List<Order> findAll() {
        return store.values().stream().toList();
    }
}
