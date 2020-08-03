package com.lee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableJpaRepositories
public class ShardingJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run( ShardingJdbcApplication.class, args );
    }
}
