package ru.job4j.dish.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.job4j.dish.service.DishService;
import ru.job4j.domain.model.Dish;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/dish")
public class DishController {

    private final DishService dishes;

    @GetMapping("/")
    public List<Dish> findAll() {
        return dishes.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Dish> findById(@PathVariable int id) {
        return dishes.findById(id);
    }

    @PostMapping("/")
    public Dish save(Dish dish) {
       return dishes.add(dish);
    }

    @PutMapping("/")
    public Dish update(Dish dish) {
        return dishes.add(dish);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        Dish toDelete = new Dish(id, null, null);
        dishes.delete(toDelete);
    }
}