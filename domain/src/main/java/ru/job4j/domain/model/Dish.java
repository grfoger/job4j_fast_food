package ru.job4j.domain.model;

import lombok.*;





@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Dish {
    @EqualsAndHashCode.Include
    private int id;
    private String name;
    private String description;
}
