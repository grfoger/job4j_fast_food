package ru.job4j.domain.model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode

public class Customer {
    private int id;
    private String login;
    private String password;
    private List<Order> orders;
    private BonusCard card;
}
