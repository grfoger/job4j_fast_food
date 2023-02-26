package ru.job4j.admin.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
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
        System.out.println(url);
        List<Dish> body = client.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Dish>>() { }).getBody();
        return body == null ? Collections.emptyList() : body;
    }

}
