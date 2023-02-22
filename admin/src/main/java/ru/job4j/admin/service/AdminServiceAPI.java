package ru.job4j.admin.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.job4j.admin.service.AdminService;
import ru.job4j.domain.model.Dish;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminServiceAPI implements AdminService {
    @Value("${api-url}")
    private static String url;

    private final RestTemplate client;

    public List<Dish> findAllDishes() {
        System.out.println(url);
        return client.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Dish>>() { }).getBody();
    }
}
