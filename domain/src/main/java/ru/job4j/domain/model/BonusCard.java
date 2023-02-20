package ru.job4j.domain.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode

public class BonusCard {
    private int id;
    private int cardNumber;
    private int discount;
    private int bonusCount;
}
