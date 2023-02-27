package ru.job4j.dish.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.dish.model.DishEntity;
import ru.job4j.dish.repository.DishRepository;
import ru.job4j.domain.model.Dish;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SimpleDishService implements DishService {

    private final DishRepository dishes;
    @Override
    public DishEntity add(DishEntity dish) {
        return dishes.save(dish);
    }

    @Override
    public DishEntity update(DishEntity dish) {
        return dishes.save(dish);
    }

    @Override
    public void delete(DishEntity dish) {
        dishes.delete(dish);
    }

    @Override
    public Optional<DishEntity> findById(int id) {
        return dishes.findById(id);
    }

    @Override
    public List<DishEntity> findAll() {
        System.out.println(dishes.findAll());
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!");
        return dishes.findAll();
    }
}
