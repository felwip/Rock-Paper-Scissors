package com.rps.restservicecors.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

public class PostgresDataSource {

    @Bean
    @ConfigurationProperties("app.datasource")
    public HikariDataSource hikariDataSource() {
        return DataSourceBuilder.create().create().type(HikariDataSource.class).build();
    }
}