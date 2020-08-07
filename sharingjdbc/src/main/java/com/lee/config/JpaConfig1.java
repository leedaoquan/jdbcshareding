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
//@EnableJpaRepositories(entityManagerFactoryRef="entityManagerFactoryMaster",
//        transactionManagerRef="transactionManagerMaster",
//        basePackages= { "com.lee.repository" })
//public class JpaConfig1 {
//
//    @Autowired
//    @Qualifier("masterDataSource")
//    private DataSource masterDataSource;
//    @Autowired
//    private JpaProperties jpaProperties;
//
//    //primary实体管理器
//    @Primary
//    @Bean(name = "entityManagerMaster")
//    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
//        return entityManagerFactoryMaster(builder).getObject().createEntityManager();
//    }
//
//    //primary实体工厂
//    @Primary
//    @Bean(name = "entityManagerFactoryMaster")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactoryMaster (EntityManagerFactoryBuilder builder) {
//        return builder
//                .dataSource(masterDataSource)
//                .properties(getVendorProperties())
//                .packages("com.lee.domain") //设置实体类所在位置
//                .persistenceUnit("primaryPersistenceUnit")
//                .build();
//    }
//
//    private Map<String, Object> getVendorProperties() {
//        HibernateSettings settings=new HibernateSettings();
//        return jpaProperties.getHibernateProperties(settings);
//    }
//
//    @Primary
//    @Bean(name = "transactionManagerMaster")
//    public PlatformTransactionManager transactionManagerMaster(EntityManagerFactoryBuilder builder) {
//        return new JpaTransactionManager(entityManagerFactoryMaster(builder).getObject());
//    }
//
//}
