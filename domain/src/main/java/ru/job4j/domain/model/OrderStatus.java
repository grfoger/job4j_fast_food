package ru.job4j.domain.model;

import lombok.*;

@Getter
public enum OrderStatus {
    NOT_AVAILABLE("Не доступен", 0),
    NOT_CONFIRMED("Не подтверждён", 1),
    CONFIRMED("Подтверждён", 2),
    CANCELED("Отменён", 3),
    SENT("Отправлен", 4),
    DELIVERED("Доставлен", 5);

    private final String statusName;
    private final int statusCode;

    private OrderStatus(String statusName, int statusCode) {
        this.statusName = statusName;
        this.statusCode = statusCode;
    }
}
