package ru.job4j.order.service;

import org.springframework.stereotype.Service;
import ru.job4j.domain.model.BonusCard;


@Service
public interface BonusCardService {

    BonusCard save(BonusCard card);
    BonusCard delete(BonusCard card);
    BonusCard findById(int id);
}
