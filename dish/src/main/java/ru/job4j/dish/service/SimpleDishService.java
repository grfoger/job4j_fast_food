package ru.job4j.dish.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.dish.repository.DishRepository;
import ru.job4j.domain.model.Dish;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SimpleDishService implements DishService {

    private final DishRepository dishes;
    @Override
    public Dish add(Dish dish) {
        return dishes.save(dish);
    }

    @Override
    public Dish update(Dish dish) {
        return dishes.save(dish);
    }

    @Override
    public void delete(Dish dish) {
        dishes.delete(dish);
    }

    @Override
    public Optional<Dish> findById(int id) {
        return dishes.findById(id);
    }

    @Override
    public List<Dish> findAll() {
        return (List<Dish>) dishes.findAll();
    }
}
