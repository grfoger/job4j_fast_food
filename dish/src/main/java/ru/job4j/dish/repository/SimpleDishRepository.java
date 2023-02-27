package ru.job4j.dish.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.domain.model.Dish;

import java.util.*;

public class SimpleDishRepository{

    Map<Integer, Dish> map = new HashMap<>();

    int count = 0;


    public Dish save(Dish dish) {
        int c = count++;
        map.put(c, dish);
        dish.setId(c);
        return dish;
    }


    public void delete(Dish dish) {
        map.remove(dish.getId(), dish);
    }


    public Optional<Dish> findById(int id) {
        return Optional.of(map.get(id));
    }


    public List<Dish> findAll() {
        return (List<Dish>) map.values();
    }

}
