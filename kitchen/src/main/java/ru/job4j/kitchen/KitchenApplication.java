package ru.job4j.kitchen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;

@SpringBootApplication(exclude = KafkaAutoConfiguration.class)
public class KitchenApplication {
    public static void main(String[] args) {
        SpringApplication.run(KitchenApplication.class, args);
    }
}
