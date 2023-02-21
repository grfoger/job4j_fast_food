package ru.job4j.domain.model;

import lombok.*;

@Getter
public enum OrderStatus {
    NOT_CONFIRMED("Не подтверждён"),
    CONFIRMED("Подтверждён"),
    SENT("Отправлен"),
    DELIVERED("Доставлен");

    private final String statusName;

    private OrderStatus(String statusName) {
        this.statusName = statusName;
    }
}
