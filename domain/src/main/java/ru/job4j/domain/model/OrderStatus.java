package ru.job4j.domain.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode

public class OrderStatus {
    private int id;
    private boolean isConfirmed;
    private boolean isDelivered;
}
