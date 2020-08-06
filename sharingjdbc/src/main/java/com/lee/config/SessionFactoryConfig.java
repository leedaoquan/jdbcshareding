package com.lee.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class SessionFactoryConfig {
    @Bean("masterDataSource")
    @Primary
    @ConfigurationProperties("spring.datasource.master") //使用application.yml的primary数据源配置
    public DataSource masterDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean("slaveDataSource")
    @ConfigurationProperties("spring.datasource.slave")
    public DataSource slaveDataSource() {
        return DruidDataSourceBuilder.create().build();
    }
}
