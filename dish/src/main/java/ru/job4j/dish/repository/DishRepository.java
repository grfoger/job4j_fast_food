package ru.job4j.dish.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.domain.model.Dish;

@Repository
public interface DishRepository extends CrudRepository<Dish, Integer> {
}
