package ru.job4j.dish.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.dish.model.DishEntity;

import java.util.List;


@Repository
public interface DishRepository extends CrudRepository<DishEntity, Integer> {
    @Override
    List<DishEntity> findAll();
}
