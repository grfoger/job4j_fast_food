package ru.job4j.kitchen.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.kitchen.model.OrderDTO;

@Repository
public interface OrderRepository extends CrudRepository<OrderDTO, Integer> {
}
