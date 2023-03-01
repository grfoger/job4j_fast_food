package ru.job4j.notification.model;

import lombok.*;
import ru.job4j.domain.model.Order;
import ru.job4j.domain.model.OrderStatus;
import ru.job4j.domain.model.Product;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "order")
@NoArgsConstructor
public class OrderEntity extends Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int orderNumber;
    private OrderStatus status;
    @OneToMany
    private List<ProductEntity> products;

    public OrderEntity(int id, int orderNumber, OrderStatus status, List<Product> products) {
        super(id, orderNumber, status, products);
    }
}