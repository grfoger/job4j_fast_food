package ru.job4j.dish.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.job4j.dish.model.DishEntity;
import ru.job4j.dish.service.DishService;
import ru.job4j.domain.model.Dish;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/dish")
public class DishController {

    private final DishService dishes;

    @GetMapping("/")
    public List<DishEntity> findAll() {
        return dishes.findAll();
    }

    @GetMapping("/{id}")
    public Optional<DishEntity> findById(@PathVariable int id) {
        return dishes.findById(id);
    }

    @PostMapping("/")
    public DishEntity save(DishEntity dish) {
       return dishes.add(dish);
    }

    @PutMapping("/")
    public DishEntity update(DishEntity dish) {
        return dishes.add(dish);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        DishEntity toDelete = new DishEntity();
        toDelete.setId(id);
        dishes.delete(toDelete);
    }
}