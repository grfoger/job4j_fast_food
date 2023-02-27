package ru.job4j.dish.configuration;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@AutoConfiguration
public class DataSourceConfiguration {
    @Bean
    public DataSource ds() {
        return new BasicDataSource();
    }
}
