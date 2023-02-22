package ru.job4j.dish.service;

import org.springframework.stereotype.Service;
import ru.job4j.domain.model.Dish;

import java.util.Collection;
import java.util.List;

@Service
public interface DishService {
    boolean add(Dish dish);
    Dish update(Dish dish);
    Dish delete(Dish dish);
    Dish findById(int id);
    Dish findByName(String name);
    List<Dish> findAll();
}
