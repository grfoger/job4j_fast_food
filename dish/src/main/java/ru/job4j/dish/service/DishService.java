package ru.job4j.dish.service;

import org.springframework.stereotype.Service;
import ru.job4j.domain.model.Dish;

import java.util.List;
import java.util.Optional;

@Service
public interface DishService {
    Dish add(Dish dish);
    Dish update(Dish dish);
    void delete(Dish dish);
    Optional<Dish> findById(int id);
    List<Dish> findAll();
}
