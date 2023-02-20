package ru.job4j.domain.model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode

public class Order {
    private int id;
    private int orderNumber;
    private OrderStatus status;
    private List<Product> products;
}
