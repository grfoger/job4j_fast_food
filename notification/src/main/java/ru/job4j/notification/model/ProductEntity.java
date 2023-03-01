package ru.job4j.notification.model;

import lombok.*;
import ru.job4j.domain.model.Product;

import javax.persistence.*;

@Entity
@Table(name = "product")
@NoArgsConstructor
public class ProductEntity extends Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private float price;

    public ProductEntity(int id, String name, float price) {
        super(id, name, price);
    }
}
