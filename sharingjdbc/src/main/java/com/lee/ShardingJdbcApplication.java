package com.lee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ShardingJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run( ShardingJdbcApplication.class, args );
    }
}
