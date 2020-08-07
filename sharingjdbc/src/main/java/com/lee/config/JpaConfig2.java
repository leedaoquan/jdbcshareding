//package com.lee.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
//import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import javax.persistence.EntityManager;
//import javax.sql.DataSource;
//import java.util.Map;
//
//@Configuration
//@EnableJpaRepositories(entityManagerFactoryRef="entityManagerFactorySlave",
//        transactionManagerRef="transactionManagerSlave",
//        basePackages= { "com.lee.repository" })
//public class JpaConfig2 {
//    @Autowired
//    @Qualifier("slaveDataSource")
//    private DataSource slaveDataSource;
//    @Autowired
//    private JpaProperties jpaProperties;
//
//    //primary实体管理器
//    @Bean(name = "entityManagerSlave")
//    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
//        return entityManagerFactorySlave(builder).getObject().createEntityManager();
//    }
//
//    //primary实体工厂
//    @Bean(name = "entityManagerFactorySlave")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactorySlave (EntityManagerFactoryBuilder builder) {
//        return builder
//                .dataSource(slaveDataSource)
//                .properties(getVendorProperties())
//                .packages("com.lee.domain") //设置实体类所在位置
//                .persistenceUnit("secondPersistenceUnit")
//                .build();
//    }
//
//    private Map<String, Object> getVendorProperties() {
//        HibernateSettings settings=new HibernateSettings();
//        return jpaProperties.getHibernateProperties(settings);
//    }
//
//    @Bean(name = "transactionManagerSlave")
//    public PlatformTransactionManager transactionManagerSlave(EntityManagerFactoryBuilder builder) {
//        return new JpaTransactionManager(entityManagerFactorySlave(builder).getObject());
//    }
//}
