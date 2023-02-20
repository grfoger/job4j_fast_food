package ru.job4j.domain.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode

public class Product {
    private int id;
    private String name;
    private float price;
}
