package ru.job4j.admin.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.job4j.domain.model.Dish;

import java.util.Collections;
import java.util.List;

@Service
public class AdminServiceAPI implements AdminService {
    @Value("${dish.url}")
    private String url;

    private final RestTemplate client;

    public AdminServiceAPI(RestTemplate client) {
        this.client = client;
    }

    @Override
    public List<Dish> findAllDishes() {
        List<Dish> body = client.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Dish>>() { }).getBody();
        return body == null ? Collections.emptyList() : body;
    }


    @Override
    public Dish save(Dish dish) {
        return client.postForEntity(
                url, dish, Dish.class).getBody();
    }

    @Override
    public Dish findById(int id) {
        return client.getForEntity(
                new StringBuilder(url).append(id).toString(), Dish.class).getBody();
    }

    @Override
    public boolean update(Dish dish) {
        return client.exchange(
                new StringBuilder(url).append(dish.getId()).toString(),
                HttpMethod.PUT,
                new HttpEntity<>(dish),
                Void.class
        ).getStatusCode() != HttpStatus.NOT_FOUND;
    }

    @Override
    public boolean delete(int id) {
        return client.exchange(
                new StringBuilder(url).append(id).toString(),
                HttpMethod.DELETE,
                HttpEntity.EMPTY,
                Void.class
        ).getStatusCode() != HttpStatus.NOT_FOUND;
    }

}
