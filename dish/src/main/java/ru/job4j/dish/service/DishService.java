package ru.job4j.dish.service;

import org.springframework.stereotype.Service;
import ru.job4j.dish.model.DishEntity;
import ru.job4j.domain.model.Dish;

import java.util.List;
import java.util.Optional;

@Service
public interface DishService {
    DishEntity add(DishEntity dish);
    DishEntity update(DishEntity dish);
    void delete(DishEntity dish);
    Optional<DishEntity> findById(int id);
    List<DishEntity> findAll();
}
