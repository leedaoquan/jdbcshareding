package com.lee.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.google.common.collect.Maps;
import groovy.util.logging.Slf4j;
import io.shardingsphere.api.config.MasterSlaveRuleConfiguration;
import io.shardingsphere.shardingjdbc.api.MasterSlaveDataSourceFactory;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


@Slf4j
@Configuration
@ConfigurationProperties(prefix = "sharding.jdbc")
//@ConditionalOnProperty({"sharding.jdbc.data-sources.ds_master.url", "sharding.jdbc.master-slave-rule.master-data-source-name"})
public class ShardingDataSourceConfig {


    @Setter
    private Map<String, DruidDataSource> dataSources = new HashMap<>();
    @Setter
    private MasterSlaveRuleConfiguration masterSlaveRule;

    @Bean("dataSource")
    public DataSource masterSlaveDataSource() throws SQLException {
//        dataSources.forEach((k, v) -> configDataSource(v));
        Map<String, DataSource> dataSourceMap = Maps.newHashMap();
        dataSourceMap.putAll(dataSources);
        DataSource dataSource = MasterSlaveDataSourceFactory.createDataSource(dataSourceMap, masterSlaveRule, Maps.newHashMap(),null);
        return dataSource;
    }

//    private void configDataSource(DruidDataSource druidDataSource) {
////        druidDataSource.setMaxActive(druidConfig.getMaxActive());
////        druidDataSource.setInitialSize(1);
////        druidDataSource.setMaxWait(60000);
////        druidDataSource.setMinIdle(1);
////        druidDataSource.setTimeBetweenEvictionRunsMillis(60000);
////        druidDataSource.setMinEvictableIdleTimeMillis(300000);
////        druidDataSource.setValidationQuery("select 'x'");
////        druidDataSource.setTestWhileIdle(true);
////        druidDataSource.setTestOnBorrow(false);
////        druidDataSource.setTestOnReturn(false);
////        druidDataSource.setPoolPreparedStatements(true);
////        druidDataSource.setMaxOpenPreparedStatements(20);
////        druidDataSource.setUseGlobalDataSourceStat(true);
//        try {
//            druidDataSource.setFilters("stat,wall,slf4j");
//        } catch (SQLException e) {
//            log.error("druid configuration initialization filter", e);
//        }
//    }
}
