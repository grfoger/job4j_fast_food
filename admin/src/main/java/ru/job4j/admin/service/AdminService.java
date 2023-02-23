package ru.job4j.admin.service;

import org.springframework.stereotype.Service;
import ru.job4j.domain.model.Dish;

import java.util.List;
@Service
public interface AdminService {

    List<Dish> findAllDishes();
}
