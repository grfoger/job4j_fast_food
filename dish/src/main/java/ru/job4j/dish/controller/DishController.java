package ru.job4j.dish.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.dish.service.DishService;
import ru.job4j.domain.model.Dish;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/dish")
public class DishController {

    private final DishService dishes;

    @GetMapping("/")
    public List<Dish> findAll() {
        return dishes.findAll();
    }
}
