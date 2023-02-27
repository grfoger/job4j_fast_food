package ru.job4j.dish.model;


import lombok.*;
import ru.job4j.domain.model.Dish;

import javax.persistence.*;

@Entity
@Table(name = "dish")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class DishEntity extends Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;
    private String name;
    private String description;

    public DishEntity(int id, String name, String description) {
        super(id, name, description);
    }
}
